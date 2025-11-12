@echo off
REM Build script for Security Utils - Java 21 LTS
REM Usage: build.bat [clean|compile|package|run]

setlocal enabledelayedexpansion

if "%1"=="" (
    echo.
    echo ========================================
    echo Security Utils - Build Script
    echo ========================================
    echo.
    echo Usage: build.bat [command]
    echo.
    echo Commands:
    echo   clean       - Remove build artifacts
    echo   compile     - Compile source files
    echo   package     - Create executable JAR
    echo   run         - Run the application
    echo   all         - Clean, compile, and package
    echo.
    goto :end
)

if "%1"=="clean" (
    echo Cleaning build artifacts...
    if exist target rmdir /s /q target
    del /q *.class 2>nul
    echo Clean completed.
    goto :end
)

if "%1"=="compile" (
    echo Compiling Java 21 source files...
    javac --release 21 *.java
    if !errorlevel! neq 0 (
        echo Compilation failed!
        exit /b 1
    )
    echo Compilation completed successfully.
    goto :end
)

if "%1"=="package" (
    echo Creating executable JAR file...
    if not exist target mkdir target
    echo Compiling and packaging...
    REM Note: This is a simplified package. Use Maven for full packaging.
    javac --release 21 *.java
    if !errorlevel! neq 0 (
        echo Compilation failed!
        exit /b 1
    )
    echo Package creation completed.
    goto :end
)

if "%1"=="run" (
    echo Running Security Utils application...
    java Main
    goto :end
)

if "%1"=="all" (
    echo Performing full build...
    call :do_clean
    call :do_compile
    echo Build completed successfully!
    goto :end
)

echo Unknown command: %1
goto :end

:do_clean
if exist target rmdir /s /q target
del /q *.class 2>nul
exit /b 0

:do_compile
javac --release 21 *.java
exit /b !errorlevel!

:end
endlocal
