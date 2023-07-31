#!/bin/bash
# Run a Java Program in the current directory
# CSC 815 Example Shell Script
# Programmer: Cruz Macias
# compile the java source code and place the class files containing the byte code in the user-defined package and place it in the pwd 
# copy MAVEN repo (third-party dependencies) into JUNit directory
# curl -s https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar -o C:/JUnit/Junit-4.12.jar
javac -d classes/ -cp C:/JUnit/Junit-4.12.jar src/junittest/TestJunit.java src/junittest/Main.java -verbose -Xlint:unchecked
# create a jar file and specify the directory where the class files live
jar --create --file lib/junittest.jar -C classes/ .
# run the compiled java program (specify the class path in the user-defined packages directory)
java -cp lib/junittest.jar;C:/JUnit/Junit-4.12.jar junittest.Main