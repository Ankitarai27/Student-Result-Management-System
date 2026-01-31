@echo off
echo Compiling Java files...
javac src/*.java

if errorlevel 1 (
    echo Compilation failed.
    pause
    exit /b
)

echo Running Student Result Management System...
java -cp src Main
pause
