import org.kohsuke.github.GHContent;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;
import java.util.Random;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GitHubCommitGenerator {

    public static void main(String[] args) {
        //gitHub credentials and presets
        String username = "your-username";//your username
        String accToken = "your-accToken";//your access token
        String repositoryName = "your-repositoryName";//your repository name
        String filePath = "your-file.md";//file in which we write
        String branch = "your-branch";//branch in which we write, prob. main
        String contentToAddFilePath = "script.txt";//file with content to add, def. script.txt
        String commitMessageToAdd = "Auto-commit: Updated state";//commit message
        int minNumberOfCommitsPerDay = 2;
        int maxNumberOfCommitsPerDay = 5;

        System.out.println("The program was started");
        try {
            String contentToAdd = new String(Files.readAllBytes(Paths.get(contentToAddFilePath)));
            System.out.println("Program got the provided txt content");
            //connect to GitHub
            GitHub github = new GitHubBuilder().withOAuthToken(accToken).build();
            GHRepository repository = github.getRepository(username + "/" + repositoryName);
            System.out.println("Connected to GitHub");
            //read current state from filePath
            GHContent content = repository.getFileContent(filePath, branch);
            String currentContent = content.getContent();//gets content from content ;)
            System.out.println("GitHub content provided" );
            //if the program was stopped midway, it will continue from there. Be sure to READ the instruction to set up the starting file in filePath variable
            String[] lines = currentContent.split("\n");
            int charactersWritten = Integer.parseInt(lines[0].split(":")[1].trim());
            int timesRewritten = Integer.parseInt(lines[1].split(":")[1].trim());
            System.out.println("The program was initiated with provided credentials and is now running\n------------------\n");
            while (true) {
                int commitsToday = new Random().nextInt(maxNumberOfCommitsPerDay - minNumberOfCommitsPerDay) + minNumberOfCommitsPerDay;
                if(commitsToday == 0) {
                    Thread.sleep(1000 * 60 * 60 * 24);//sleep for 24h if there are no commits today
                }
                for (int i = 0; i < commitsToday; i++) {
                    if (charactersWritten >= contentToAdd.length()) {
                        charactersWritten = 0;
                        timesRewritten++;
                    }
                    charactersWritten++;
                    for (int k = 0; k < 5; k++) {//code for catching exceptions and retrying the update operation
                        try {
                            repository.getFileContent(filePath, branch).update("<pre>Number of characters written: " + charactersWritten + "\nTimes rewritten: " + timesRewritten + "\n" + contentToAdd.substring(0, charactersWritten-1), commitMessageToAdd);//update content
                            break;
                        } catch (Exception e) {
                            if (k < 4) {
                                try {//wait for 1 second before retrying
                                    Thread.sleep(1000);
                                } catch (InterruptedException ie) {
                                    Thread.currentThread().interrupt();
                                }
                            } else {
                                throw e;//re-throw the exception if we've reached the maximum number of retries
                            }
                        }
                    }
                    Thread.sleep((24*60*60*1000)/commitsToday);//sleep for 24h/number of commits for today
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}