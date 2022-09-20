:: Run a Java Program in the current directory
:: CSC 730 Homework 3 Solutions
:: Programmer: Cruz Macias
@ECHO OFF
color 0a

::cd "C:\Users\C\Desktop\JavaPrograms\csc730\hw_3"

:: compile the java source code and place the class files containing the byte code in the user-defined package and place it in the pwd 
:: javac -d . HomeWork3App.java

:: alternative compile options

:: list what the compiler is doing
:: javac -d . HomeWork3App.java -verbose

:: to list warning details
echo compile and build Java program
pause
javac -d . HomeWork3App.java -verbose -Xlint:unchecked
:: run the compiled java program (specify the class path in the user-defined packages directory)
echo run Java program
pause
::java homework3app.HomeWork3App > output.txt
java homework3app.HomeWork3App
::echo running ...
::echo program result:
::pause
::cat output.txt
pause