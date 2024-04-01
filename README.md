# Auto-Commit-To-GitHub-Program-Shrek-Version
<h2><b>NOTE: THIS IS OBVIOUSLY A JOKE BUT IT WAS STILL A FUN ONE-DAY PROJECT I CAME UP WITH :NOTE</b></h2>


A Java-based program that auto-commits whichever script you want (character by character) to your GitHub repository at random intervals during the day, making your contribution graph look cool 😎. The published version is based on the Shrek script.
<h3>SETUP</h3>
Before starting the program make sure you do those things:

- If you haven't already, install Gradle, and Java from their official websites to your device.

- Create a .md file in your end GitHub repository, to which the text will be written, and initiate it by adding the following text to it:
<pre>&lt;pre&gt;Number of characters written: 0
Times rewritten: 0</pre>
This will be used so the program will know where to start.

Then go to this location app/src/main/java/org/example/app/. and open the GitHubCommitGenerator.java, to set up the next values at the start of the program:
<pre>//gitHub credentials and presets
String username = "your-username";//your username
String accToken = "your-accToken";//your access token
String repositoryName = "your-repositoryName";//your repository name
String filePath = "your-file.md";//file in which we write
String branch = "your-branch";//branch in which we write, prob. main
String contentToAddFilePath = "script.txt";//file with content to add, def. script.txt
String commitMessageToAdd = "Auto-commit: Updated state";//commit message
int minNumberOfCommitsPerDay = 2;
int maxNumberOfCommitsPerDay = 5;</pre>
<b>your-username:</b> Should be your GitHub username

<b>your-accToken:</b> Your GitHub API access Token. To get it, click on your GitHub profile, Settings, Developer settings, Personal access tokens, Tokens (classic), and generate a new token with repo and project permissions enabled.

<b>your-repositoryName:</b> Name of the repository you want to commit to.

<b>your-file.md:</b> Name of the .md file in that repository.

<b>your-branch:</b> Branc, usually main

<b>contentToAddFilePath:</b> By default it is script.txt, and is set to the Shrek script. This file contains the text you want to commit to the .md file. It resides in app/. folder.

<b>commitMessageToAdd:</b> Message that will be added whenever you commit a change.

<b>min and max value for daily commits:</b> minNumberOfCommitsPerDay and maxNumberOfCommitsPerDay.

<h3>HOW TO START AND END THE PROGRAM</h3>
To start the program make sure you are in the root of the folder and open it in the terminal. Then, start the program with <pre>gradle build
gradle run</pre> commands for Windows.

If everything goes right your program should start running and the following lines will be printed:
<pre>> Task :app:run
The new program was started
Program got the provided txt content
Connected to GitHub
GitHub content provided
The program was initiated with provided credentials and is now running
------------------</pre>
It should take a few seconds, but sometimes GitHub needs a bit more time to connect.

If you get any errors that stop the program mid-running (probably when you lose internet connection), just restart the program.

In case you get any error like this:
<pre>Month DD, YYYY 0:00:00 PM org.kohsuke.github.GitHubClient retryConnectionError</pre>
and your program is still running don't worry, this might happen from time to time when trying to update the content in the provided .md file. There is a code in place to wait for 1s before retrying the update. If this happens 5 consecutive times, the final error will be printed, and the program will get stopped.

When you want to end the program, just press Ctrl+C and type Y in the terminal, or press Ctrl+C two times.

<h3>END</h3>
I hope this will get you the GH contribution graph you always wanted 😉.

For any questions ask Chat GPT

<pre>⢀⡴⠑⡄⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ 
⠸⡇⠀⠿⡀⠀⠀⠀⣀⡴⢿⣿⣿⣿⣿⣿⣿⣿⣷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀ 
⠀⠀⠀⠀⠑⢄⣠⠾⠁⣀⣄⡈⠙⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀ 
⠀⠀⠀⠀⢀⡀⠁⠀⠀⠈⠙⠛⠂⠈⣿⣿⣿⣿⣿⠿⡿⢿⣆⠀⠀⠀⠀⠀⠀⠀ 
⠀⠀⠀⢀⡾⣁⣀⠀⠴⠂⠙⣗⡀⠀⢻⣿⣿⠭⢤⣴⣦⣤⣹⠀⠀⠀⢀⢴⣶⣆ 
⠀⠀⢀⣾⣿⣿⣿⣷⣮⣽⣾⣿⣥⣴⣿⣿⡿⢂⠔⢚⡿⢿⣿⣦⣴⣾⠁⠸⣼⡿ 
⠀⢀⡞⠁⠙⠻⠿⠟⠉⠀⠛⢹⣿⣿⣿⣿⣿⣌⢤⣼⣿⣾⣿⡟⠉⠀⠀⠀⠀⠀ 
⠀⣾⣷⣶⠇⠀⠀⣤⣄⣀⡀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ 
⠀⠉⠈⠉⠀⠀⢦⡈⢻⣿⣿⣿⣶⣶⣶⣶⣤⣽⡹⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ 
⠀⠀⠀⠀⠀⠀⠀⠉⠲⣽⡻⢿⣿⣿⣿⣿⣿⣿⣷⣜⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ 
⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣷⣶⣮⣭⣽⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀ 
⠀⠀⠀⠀⠀⠀⣀⣀⣈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀ 
⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀ 
⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀ 
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠻⠿⠿⠿⠿⠛⠉</pre>
