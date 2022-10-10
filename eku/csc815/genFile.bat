:: batch script to generate a directory with a unique name
:: DATETIME format: YYYYMMDDHHMMSS
@ECHO OFF
touch file_%DATE:~-4,4%%DATE:~-10,2%%DATE:~-7,2%%TIME:~0,2%%TIME:~3,2%%TIME:~6,2%.txt
pause