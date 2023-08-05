#!/bin/bash
# Run a Java Program in the current directory
# CSC 835 Assignment 4 Shell Script
# Programmer: Cruz Macias
# compile the java source code using the Maven Build Tool and place the class files containing the byte code in the maven-defined package and place it in the pwd 
# copy MAVEN repos (third-party dependencies) into JUNit directory
# curl -s https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar -o lib/Junit-4.12.jar
# curl -s https://repo1.maven.org/maven2/org/junit/jupiter/junit-jupiter-api/5.10.0/junit-jupiter-api-5.10.0.jar -o lib/junit-jupiter-api-5.10.0.jar
# curl -s https://repo1.maven.org/maven2/org/junit/jupiter/junit-jupiter-api/5.7.0/junit-jupiter-api-5.7.0.jar -o lib/junit-jupiter-api-5.7.0.jar
# curl -s https://repo1.maven.org/maven2/junit/junit/3.8.1/junit-3.8.1.jar -o lib/junit-3.8.1.jar 
# generate the project using maven build tool (comment out after project files are generated)
# mvn archetype:generate -DgroupId=edu.eku -DartifactId=csc835-assignment-4 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
# compile the program using maven build tool
mvn compile
# compile the JUnit test program using maven build tool
mvn test
# create a jar file using the maven build tool
# place the class files containing the byte code in the maven-defined package
mvn package
# build dependency trees
# mvn dependency:tree -Dincludes=velocity:velocity
# run the compiled java program (specify the class path in the user-defined packages directory)
java -cp target/csc835-assignment-4-1.0-SNAPSHOT.jar edu.eku.SmallestAndLargest