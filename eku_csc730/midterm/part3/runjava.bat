:: Run a Java Program in the current directory
:: CSC 730 Midterm Part 3 Programming Problems
:: Programmer: Cruz Macias
@ECHO OFF
color 0a

:: compile the java source code and place the class files containing the byte code in the user-defined package and place it in the pwd 
:: javac -d . MidtermPart3.java

:: alternative compile options

:: list what the compiler is doing
:: javac -d . MidtermPart3.java -verbose

:: to list warning details
echo compile and build Java program
pause
javac -d . MidtermPart3.java -verbose -Xlint:unchecked
:: run the compiled java program (specify the class path in the user-defined packages directory)
echo run Java program
pause
java midtermpart3.MidtermPart3 > output.txt
echo running ...
echo program result:
pause
cat output.txt
pause