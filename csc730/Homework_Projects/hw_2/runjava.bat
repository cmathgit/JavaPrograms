:: Run a Java Program in the current directory
:: CSC 730 Homework 2 Solutions
:: Programmer: Cruz Macias
@ECHO OFF
color 0a

::cd "C:\Users\C\Desktop\JavaPrograms\csc730\hw_2"

:: compile the java source code and place the class files containing the byte code in the user-defined package and place it in the pwd 
::javac -d . HomeWork2App.java

:: alternative compile options

:: list what the compiler is doing
:: javac -d . HomeWork2App.java -verbose

:: to list warning details
javac -d . HomeWork2App.java -Xlint:unchecked

:: run the compiled java program (specify the class path in the user-defined packages directory)
java homework2app.HomeWork2App
pause