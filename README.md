# JavaPrograms
# Various Java program solutions for Computer Science 730 Data Structures and Algorithms at Eastern Kentucky University
# More courses may be inlcuded in the future
# Personal Java projects for various programming problems

# set-up SSH (must have Git installed on your machine or use GitBash)
# this example uses git.exe from Cygwin installation 
# to see if you have git on your machine, open Windows cmd and execute C>where git

# generate SSH key (skip passphrase)
```
ssh-keygen -t rsa -b 4096 -C "<your email address : same as Github login>"
```
# enter to accept default directory or designate one, e.g., ~/.ssh/id_rsa
# enter twice to skip passphrase
# navigate to new directory where the ssh key lives
```
cd .ssh
ls
```
# id_rsa and id_rsa.pub are the private and public keys, respectively
# open the services GUI (start >> search >> services)
# start the OpenSSH Authentication Agent (Right-Click >> Startup Type: Automatic >> Service Status: Start
# open the terminal in the .ssh directory and execute
```
ssh-add ~/.ssh/id_rsa
```
# copy public key to clipboard
```
cat id_rsa.pub | clip
```
# Open Github account: settings >> SSH and GPG keys >> New SSH Key >> Title: PC >> Key: "<Paste from clipboard>" >> Add SSH Key
  
 
# How to clone repo to original machine with SSH (may be password protected)
# open the repo you want to clone from Github account: Code >> SSH >> copy <repository_url>
```
git@github.com:<username>/JavaPrograms.git
```
# in a new shell, open the directory where you want the repo to be cloned
```
cd Desktop/projects
git clone <repository_url>
git status
```
# How to clone repo to any machine with SSH (may be password protected)
# open the repo you want to clone from Github account: Code >> HTTPS >> copy <repository_url>
```
https://github.com/username/JavaPrograms.git
```
# in a new shell, open the directory where you want the repo to be cloned
```
cd Desktop/projects
git clone <repository_url>
git status
```

# Update remote repo
# Step 1. Stage the changes (1st status red. 2nd status green.)
```
git status
git add ./
git status
```
# Step 2. Commit the changes (identify yourself and commit : use --global for all repos or omit to set identity for this repo only)
```
git config user.email "alias@example.com"
git commit -m "upload most recent changes"
```
# Step 3. Push the changes to the remote repo
```
git push
```
  
# How to compile Java in Unix / Linux
```
javac -d classes/ -cp lib/sample-1.jar src/project/Example.java -verbose -Xlint:unchecked

jar --create --file lib/sample-2.jar -C classes/ .
```
# How to run Java Unix / Linux
```
java -cp lib/sample-2.jar:lib/sample-1.jar project.Example > output.txt
```

# How to run Java in Windows
```
java -cp lib/sample-2.jar;lib/sample-1.jar project.Example > output.txt
```

# Requirements
```
JDK 17+
JRE 17+
```

# install Java in Windows visit
```
https://docs.oracle.com/en/java/javase/18/install/installation-jdk-microsoft-windows-platforms.html#GUID-DAF345BA-B3E7-4CF2-B87A-B6662D691840
```

# Update Path Variable in Windows (Access javac, jar, and java commands)
```
Option 1. 
Open the System Properties and add the paths with the javac, jar, and java executables to your PATH environment variable.
Go to Settings >> System >> About >>  Advanced system settings >> Environment Variables >> System Variables >> Path >> Edit >> New 
copy the paths, e.g., C:\Program Files\Java\jdk-18.0.2.1\bin, into here.

Option 2. Excute PATH command. Copy the return string (should have a list of paths semi-colon delimited). Append path to JDK binary and library directors separated by a semi-colon, e.g., 

user> PATH
PATH=C:\Program Files\Common Files\Oracle\Java\javapath;C:\cygwin64\bin

user> PATH C:\Program Files\Common Files\Oracle\Java\javapath;C:\cygwin64\bin;C:\Program Files\Java\jdk-18.0.2.1\lib;C:\Program Files\Java\jdk-18.0.2.1\bin

user> PATH
PATH=C:\Program Files\Common Files\Oracle\Java\javapath;C:\cygwin64\bin;C:\Program Files\Java\jdk-18.0.2.1\lib;C:\Program Files\Java\jdk-18.0.2.1\bin
```

# How to compile in Windows (back slash)
```
javac -d classes/ -cp lib\sample-1.jar src\project\Example.java -verbose -Xlint:unchecked
jar --create --file lib\sample-2.jar -C classes/ .
```

# How to run in Windows (semi-colon)
```
java -cp lib\sample-2.jar;lib\sample-1.jar project.Example > output.txt
```

# Maven JSON Simple 1.1.1 (Third Party Package) Repo Example
```
https://repo1.maven.org/maven2/com/googlecode/json-simple/json-simple/1.1.1/json-simple-1.1.1.jar
```

# Adding Maven JSON Simple 1.1.1 (Third Party Package) Repo to your lib directory (Example API Call to Download Repo File(s))
```
curl -s https://repo1.maven.org/maven2/com/googlecode/json-simple/json-simple/1.1.1/json-simple-1.1.1.jar -o lib\json-simple.jar
```

# Coindesk BTC API endpoint (Example API Call to retrieve JSON payload)
```
https://api.coindesk.com/v1/bpi/currentprice.json
```

# Sending a Request to Coindesk BTC API endpoint and saving the returned payload
```
curl -# -o api_payload.json https://api.coindesk.com/v1/bpi/currentprice.json
```

# Maven JSON Simple (Third Party Package) Repo
```
https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1
```

# Oracle JDK 18.0.2 Installer
```
https://www.oracle.com/java/technologies/downloads/#jdk18-windows
```

# Oracle JDK 18.0.2 Installer Tutorial
```
https://docs.oracle.com/en/java/javase/18/install/installation-jdk-microsoft-windows-platforms.html#GUID-DAF345BA-B3E7-4CF2-B87A-B6662D691840
```

# Cygwin Get that Linux feeling - on Windows
```
https://www.cygwin.com/
```

# Check if you have Linux commands on your Windows machine
```
Open CMD and type the command, e.g., ls or vim
If it exists, use where to see where it lives, e.g., where ls or where nano
If it does not exist, you will need to install something like Gitbash or CygWin
```

# Install Java (Linux, Ubuntu 20.04)
```
sudo apt update
sudo apt upgrade
sudo apt install openjdk-17-jdk openjdk-17-jre
```

# How to compile in Ubuntu (forward slash)
```
javac -d classes/ -cp lib/sample-1.jar src/project/Example.java -verbose -Xlint:unchecked
jar --create --file lib/sample-2.jar -C classes/ .
```

# How to run in Ubuntu (colon)
```
java -cp lib/sample-2.jar:lib/sample-1.jar project.Example > output.txt
```

