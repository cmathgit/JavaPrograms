:: Run a Java Program in the current directory
:: CSC 730 Fibal Part 1 Programming Problems
:: Programmer: Cruz Macias
@ECHO OFF
color 06

:: compile the java source code and place the class files containing the byte code in the user-defined package and place it in the pwd 
:: javac -d . FinalP1.java

:: alternative compile options

:: list what the compiler is doing
:: javac -d . FinalP1.java -verbose

:: remove any existing dependencies
::echo removing jars, class definitions, and json payload
::echo enter to confirm
::pause

::rm -f lib\finalp1.jar
::rm -rf classes/*

:: to list warning details
echo compile and build Java program
pause
javac -d classes/ src\finalp1\FinalP1.java -verbose -Xlint:unchecked

:: create a jar file and specify the directory where the class files live
echo create jar files
jar --create --file lib\finalp1.jar -C classes/ .
::ls lib
pause

:: run the compiled java program (specify the class path in the user-defined packages directory)
echo run Java program
pause
::java finalp1.FinalP1 > output.txt
java -cp lib\finalp1.jar finalp1.FinalP1
::echo running ...
::echo program result:
::pause
::cat output.txt
pause