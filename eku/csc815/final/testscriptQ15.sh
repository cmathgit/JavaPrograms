#!/bin/bash
# shell script to count the number of writable files in the pwd and display result
# programmer: Cruz Macias

# define the usage of the script
if [ $# -eq 0 ]
then
	echo "The number of writeable files in " $(pwd) " is " $(find -maxdepth 1 -type f -writable | wc -l)
else
	echo "Usage: testscriptQ15 [No args...run in pwd]"
fi
