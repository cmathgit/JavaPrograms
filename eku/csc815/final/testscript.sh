#!/bin/bash
# shell script to accept arguments from the user at runtime and print in the reverse order
# programmer: Cruz Macias

# define the usage of the script
if [ $# -eq 0 ]
then
	echo "Usage: testscript [arg...char(1 or more)]"
else
	# print args in order entered
	echo $@

	# print args in reverse order using the tac utility
	printf "%s " "$@" | tac
	printf "\n"

	# print in revere order using a for loop
	for ((i=$#;i>=1;i--))
	do
		printf "${!i} "
	done
fi
