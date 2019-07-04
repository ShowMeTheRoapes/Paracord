@echo off

echo ***************************************************
echo **            Building REST server               **
echo ***************************************************
cd server
call mvn clean package || goto :error


echo ***************************************************
echo **             Starting REST server              **
echo ***************************************************
start cmd /k "java -jar target/paracord-server-executable.jar && exit"
timeout /t 5 /nobreak > NUL
echo =========S T A R T E D=========
cd ..

echo ***************************************************
echo **             Building React App                **
echo ***************************************************
echo Pulling React dependencies
cd paracord-ui
echo Pulling React dependencies
call yarn || goto :error

echo ***************************************************
echo **             Starting React App                **
echo ***************************************************
start cmd /k "yarn start && exit"
timeout /t 5 /nobreak > NUL
echo =========S T A R T E D=========
cd ..

set /p DUMMY=The applications have started! Hit ENTER to close...
goto :EOF

:error
echo One of the build steps has failed.
set /p DUMMY=Hit ENTER to close...
exit
