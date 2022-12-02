#!/bin/bash
# shell script to loop from 1 to 5

for v in {1..5}
do
 	echo  "iterate $v"
done

for ((i=1; i <=10; i++))
do
	echo "i $i"
done

for curfile in `ls *.txt`
do
	lpr $curfile
done

echo "Enter a number:"
read u_in
echo $u_in
