# 🔒 Security Utils - Java Security Toolkit

![Java](https://img.shields.io/badge/Java-8+-blue?style=for-the-badge&logo=java)
![Security](https://img.shields.io/badge/Security-Toolkit-green?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

A comprehensive security tool developed in Java with colored terminal interface and advanced features for security analysis and generation.

## ✨ Key Features

- 🎨 **Colored interface** - Terminal with ANSI colors and modern design
- 🔐 **Multiple algorithms** - MD5, SHA-256, SHA-512, AES
- 🛡️ **Smart analysis** - Detailed password strength verification
- 🎯 **Flexible generation** - Secure and memorable passwords
- 💾 **Auto-saving** - Results logging to files
- 🔄 **Hash comparison** - Integrity verification
- 📊 **Detailed reports** - Improvement suggestions and metrics

## 🚀 Getting Started

### Prerequisites

- Java 8 or higher
- Terminal supporting ANSI colors (Linux, MacOS, Windows Terminal)

### Quick Installation

1. **Download all files to the same directory**

2. **Compile the project:**
```bash
javac *.java

run: java Main

project structure:
security-utils/
├── Main.java                 # Main interface
├── TerminalUtils.java        # Colored terminal utilities
├── PasswordChecker.java      # Password strength analyzer
├── PasswordGenerator.java    # Secure password generator
├── HashGenerator.java        # Hash generator
├── Encryptor.java           # AES encryption
├── FileManager.java         # File manager
├── password_analysis.txt    # Saved results (auto-generated)
├── generated_passwords.txt  # Generated passwords (auto-generated)
└── README.md               # This file

