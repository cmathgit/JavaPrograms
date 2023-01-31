# Programmer: Cruz Macias
# Purpose: Create a shell script to run all commands for data collection as detailed on page 149 of the course textbook
# Command to execute: bash cSysDataCollector.sh
# DATETIME format: YYYYMMDDHHMMSS
# varDate=$(date +"%Y%m%d%H%M%S")
#varDate=$(date +"%Y%m%d")
echo $(date)
# generate a file with a unique name
# use this command to create a text file (.txt) inf the following format: cDataCollection_YYYYMMDD.txt
# touch cDataCollection_$varDate.txt
# comment the above command and replace the filename below with the same YYYYMMDD as the file generated
# collect live response data from the system and append to an existing file
echo "System Date: " $(date) $(systeminfo) $(net user) $(net group) $(ipconfig /all) $(route print) $(arp -a) $(ipconfig /displaydns) $(netstat -abn) >> "cSysDataCollection_Results.txt" 
#echo "System Information: " $(systeminfo) >> "cDataCollection_Results.txt" 
