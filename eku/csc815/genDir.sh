# shell script to generate a directory with a unique name
# DATETIME format: YYYYMMDDHHMMSS
# execute bash genDir.sh to run
# touch folder$(date +"%Y%m%d%H%M%S")
# mkdir folder$(date +"%Y%m%d%H%M%S")
varDate=$(date +"%Y%m%d%H%M%S")
mkdir folder$varDate