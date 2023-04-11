:: Programmer: Cruz Macias
:: Purpose: Create a shell script to run all commands for data collection as detailed on page 149 of the course textbook
:: Command to execute: bash cSysDataCollector.sh
:: DATETIME format: YYYYMMDDHHMMSS
:: varDate=$(date +"%Y%m%d%H%M%S")
:: varDate=$(date +"%Y%m%d")
@ECHO OFF
date /T
time /T
:: generate a file with a unique name
:: touch cSysDataCollection_%DATE:~-4,4%%DATE:~-10,2%%DATE:~-7,2%.txt
:: use this command to create a text file (.txt) inf the following format: cDataCollection_YYYYMMDD.txt
:: collect live response data from the system and append to an existing file
touch cSysDataCollection_Results.txt
echo System Date: >> cSysDataCollection_Results.txt
date /T >> cSysDataCollection_Results.txt
echo System Time: >> cSysDataCollection_Results.txt
time /T >> cSysDataCollection_Results.txt
systeminfo >> cSysDataCollection_Results.txt
net user >> cSysDataCollection_Results.txt
net group >> cSysDataCollection_Results.txt
ipconfig /all >> cSysDataCollection_Results.txt
route print >> cSysDataCollection_Results.txt
arp -a >> cSysDataCollection_Results.txt
ipconfig /displaydns >> cSysDataCollection_Results.txt
netstat -abn >> cSysDataCollection_Results.txt
pause