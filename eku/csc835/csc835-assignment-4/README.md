# Assignment 4 - TDD with JUnit 
```
/*
Please read the report in JavaPrograms\eku\csc835\csc835-assignment-4\target\surefire-reports\csc835-Assign4-Cruz-Macias.pdf
Screenshots included for clarity.

The purpose of this assignment is to practice Test-Driven Development with JUnit.  To complete this assignment, you will implement the algorithm/function described below with the following procedure: 

This Project will use the Maven Build Tool for testing the Java Program with JUnit in the Cygwin POSIX Development Environment where JDK 11+ among other CLTs are installed. No IDE will be utilized for Test Cases. With Apache Maven Version 3.9.4 installed, in the project root directory, the project archetype is generated using the following maven command : 

mvn archetype:generate -DgroupId=edu.eku -DartifactId=csc835-assignment-4 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false 

With the project generated, modify the src files for both main and test to reflect the name of the project: SmallestAndLargest.java and SmallestAndLargestTest.java. Replace the source code with the code utilizing the straightforward algorithm for finding the smallest and largest values in an array. Modify the pom.xml (Project Object Model XML file) file and define the JUnit dependencies being used: JUnit Vesrion 4.13.2. Confirm that each of the Maven Commands being used will execute without issue and the program runs: mvn compile, mvn test, mvn package, and java. Create 7 test cases for the new code being tested which is an improved processing algorithm for accomplishing the task of finding the smallest and largest values in an array. With each test case, modify the source code until it passes without fail. Once the code passes all test cases, refactor the code and comment where applicable. 

Having used JUnit with the Maven Build tool via the command line for testing Java code for a given project, the value of TDD is demonstrated with respect to the development environment whether that is a custom environment like the one used in this report or an IDE such as Eclipse. Instead of running the program with hard coded values or passing in the same values again and again, the JUnit test case confirms if the expected output is achieved for a given test case. This is far more convenient and documented than trying different scenarios without recording results. These test cases can be used again and again throughout the development life cycle providing assurance to the project stakeholders and developers. 
*/
```

#Install Cygwin
```
//Install the POSIX Development Environment. Incude the CLTs by adding the bin directory path to your PATH environment variable.
C:\cygwin64\bin
```

#Install JDK 11+
```
//Follow the Oracle guide in root to install JDK and include the Java CLTs in your PATH environment variable.
C:\Program Files\Common Files\Oracle\Java\javapath
C:\Program Files\Java\jdk-20\bin
```

#Install Maven Build Tool
```
//Unarchive the compressed container for the version of Maven you will use and save to your machine. Include the binaries directory path in your PATH environment variable.
C:\Program Files\apache-maven-3.9.4\bin

//Run this command to confirm the maven build tool is installed
mvn --version
```

# Generate the Jave project using Maven Build Tool
```
// change the groupID and artifactID to whatever you like
mvn archetype:generate -DgroupId=edu.eku -DartifactId=csc835-assignment-4 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

# Modify the resulting Project Object Model dependencies
```
// point to the version of JUnit you would like to use
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.13.2</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
```

# Alternatively, Add the JUnit jar files from the Maven Repo directly to the project library
```
curl -s https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar -o lib/Junit-4.13.2.jar
```

# Execute the Maven Commands: compile, test, and package
```
// Compile builds the Java program and generates the class files
mvn compile

// Test runs the Java program for the Test Cases defined in the Test.java file
// Remember, assertEquals(expected, actual) will compare object references if the values are not specifies and the test will fail since the references to different objects are indeed different.
mvn Test

//package the project and and generate the jar files
mvn package
```

# Run the Java Program
```
//example
java -cp target/csc835-assignment-4-1.0-SNAPSHOT.jar edu.eku.SmallestAndLargest
```

# Alternatively, a shell script can be used  to execute most of the above commands
```
#!/bin/bash
# Shell Script Name: runJavaWithMaven.sh
# Run a Java Program in the current directory
# compile the java source code using the Maven Build Tool and place the class files containing the byte code in the maven-defined package and place it in the pwd 
# copy MAVEN repos (third-party dependencies) into JUNit directory
# curl -s https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar -o lib/Junit-4.13.2.jar

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
```

# Execute the script
```
bash runJavaWithMaven.sh
```