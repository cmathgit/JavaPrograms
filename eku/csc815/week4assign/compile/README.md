# Solution for Week 4 Assignment not included due to Academic Integrity Policy but will be inlcuded upon course completion
# CSC 815 Week 4 Assignment - Shell Script
# Cruz Macias
# Create a shell script "compile" that will compile and run a C or Java program.  The user will type "compile x.c" or "compile y.java" on the command line.  
# Your script should call "gcc" or "javac" as appropriate, and run the resulting program if the compile finishes without any errors.

# Script Instructions
# Include at most one parameter in the execution. This parameter must be a Java or C program. Try including zero, more than one, or the testfile.txt as your input.

# Requirements
```
JDK 11+
JRE 11+
GCC
```

# To Run the Script without Parameters
```
./compile.sh
```

# or Try
```
bash compile.sh
```

# To Run a Java Program
```
bash compile.sh y.java
```

# To Run a C Program
```
bash compile.sh x.c
```

# Running compile.sh EKU Student VM version
# You will need to install JDK-11 and GCC onto the VM

# For javac
```
sudo apt install openjdk-11-jdk-headless
which javac
```

# For java
```
sudo apt install openjdk-11-jre-headless
which java
```

# For gcc
```
sudo apt install gcc
which gcc
```

# Use the VM version of compile.sh
# Run this command to run the script on the VM after installing the respective packages listed above
```
bash compile.sh
```

# To Run a Java Program
```
bash compile.sh y.java
```

# To Run a C Program
```
bash compile.sh x.c
```

# Install Java (Linux, Ubuntu 20.04)
```
sudo apt update
sudo apt upgrade
sudo apt install openjdk-11-jdk-headless openjdk-11-jre-headless gcc
```

# How to check if the executable lives in the binaries directory (Ubuntu)
```
which javac
which jar
which java
which gcc
```

# How to compile Java in Unix / Linux
```
javac -d classes/ -cp lib/sample-1.jar src/project/Example.java -verbose -Xlint:unchecked
jar --create --file lib/sample-2.jar -C classes/ .
```

# How to compile Java in Ubuntu (forward slash)
```
javac -d classes/ -cp lib/sample-1.jar src/project/Example.java -verbose -Xlint:unchecked
jar --create --file lib/sample-2.jar -C classes/ .
```

# How to run Java in Ubuntu (colon)
```
java -cp lib/sample-2.jar:lib/sample-1.jar project.Example > output.txt
```

# How to compile C in Ubuntu 
```
gcc main.c
```

# How to run C in Ubuntu 
```
./a.out
```

# or Try
```
./a.exe
```