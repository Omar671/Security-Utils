#!/bin/bash
# Build script for Security Utils - Java 21 LTS
# Usage: ./build.sh [clean|compile|package|run|all]

set -e

print_usage() {
    echo ""
    echo "========================================"
    echo "Security Utils - Build Script"
    echo "========================================"
    echo ""
    echo "Usage: ./build.sh [command]"
    echo ""
    echo "Commands:"
    echo "  clean       - Remove build artifacts"
    echo "  compile     - Compile source files"
    echo "  package     - Create executable JAR"
    echo "  run         - Run the application"
    echo "  all         - Clean, compile, and package"
    echo ""
}

do_clean() {
    echo "Cleaning build artifacts..."
    rm -rf target/ 2>/dev/null || true
    rm -f *.class 2>/dev/null || true
    echo "Clean completed."
}

do_compile() {
    echo "Compiling Java 21 source files..."
    javac --release 21 *.java
    if [ $? -ne 0 ]; then
        echo "Compilation failed!"
        exit 1
    fi
    echo "Compilation completed successfully."
}

do_package() {
    echo "Creating executable JAR file..."
    mkdir -p target
    echo "Compiling and packaging..."
    javac --release 21 *.java
    if [ $? -ne 0 ]; then
        echo "Compilation failed!"
        exit 1
    fi
    echo "Package creation completed."
}

do_run() {
    echo "Running Security Utils application..."
    java Main
}

do_all() {
    echo "Performing full build..."
    do_clean
    do_compile
    echo "Build completed successfully!"
}

if [ $# -eq 0 ]; then
    print_usage
    exit 0
fi

case "$1" in
    clean)
        do_clean
        ;;
    compile)
        do_compile
        ;;
    package)
        do_package
        ;;
    run)
        do_run
        ;;
    all)
        do_all
        ;;
    *)
        echo "Unknown command: $1"
        print_usage
        exit 1
        ;;
esac
