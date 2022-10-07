# shell script to generate a directory with a unique name
# DATETIME format: YYYYMMDDHHMMSS
# execute bash genFile.sh to run
varDate=$(date +"%Y%m%d%H%M%S")
touch file$varDate.txt