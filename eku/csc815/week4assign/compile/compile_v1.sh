#!/bin/bash
# shell script to compile and run a given Java or C program
# define the usage of the script, that is, must have at most one parameter when called
if [ $# -eq 0 -o $# -gt 1 ] 
then
	echo "Usage: compile [arg...Java or C program]"
else
	#echo "run the program "$1
	# if the parameter provided contains the extension .java, i.e., is a Java program, use javac, else, do nothing
	if [[ $1 == *.java ]]
	then
		echo $1" is a Java program. Compile and run "$1
		# compile the java program using javac; not required for single-file source code since Java 11
		javac $1
		# run the java program using java 
		java $1
		# remove the class packages created, i.e, make clean
		rm *.class
	else
		echo $1" is not a Java program."
	fi
	# if the parameter provided contains the extension .c, i.e., is a C program, use gcc, else, do nothing
	if [[ $1 == *.c ]]
	then
		echo $1" is a C program. Compile and run "$1
		# compile the c program using gcc and create a name for the object file or executable (remove the -o option to default the name of the executable to a.exe or a
		# gcc -o ccprog $1
		gcc $1
		# run the c program by calling the executable
		# ./ccprog
		./a
		# remove the executables created, i.e, make clean
		rm *.exe
	else
		echo $1" is not a C program. Please rerun the program and include a Java or C program."
	fi
fi