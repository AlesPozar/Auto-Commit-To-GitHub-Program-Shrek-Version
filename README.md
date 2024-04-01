# Auto-Commit-To-GitHub-Program-Shrek-Version
A Java-based program that auto-commits whichever script you want (character by character) to your GitHub repository at random intervals during the day, making your contribution graph look cool 😎. The published version is based on the Shrek script.
<h3>SETUP</h3>
Before starting the program create a .md file in your end GitHub repository, to which the text will be written, and initiate it by adding the following text to it:
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
int minNumberOfCommitsPerDay = 2;//(exclusive)
int maxNumberOfCommitsPerDay = 5;//(inclusive)</pre>
<b>your-username:</b> Should be your GitHub username

<b>your-accToken:</b> Your GitHub API access Token. To get it, click on your GitHub profile, Settings, Developer settings, Personal access tokens, Tokens (classic), and generate a new token with repo and project permissions enabled.

<b>your-repositoryName:</b> Name of the repository you want to commit to.

<b>your-file.md:</b> Name of the .md file in that repository.

<b>your-branch:</b> Branc, usually main

<b>contentToAddFilePath:</b> By default it is script.txt, and is set to the Shrek script. This file contains the text you want to commit to the .md file. It resides in app/. folder.

<b>commitMessageToAdd:</b> Message that will be added whenever you commit a change.

<b>min and max value for daily commits:</b> minNumberOfCommitsPerDay and maxNumberOfCommitsPerDay. (min, max]
