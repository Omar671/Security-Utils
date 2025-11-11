# 🔒 Security Utils - Java Security Toolkit

![Java](https://img.shields.io/badge/Java-8+-blue?style=for-the-badge&logo=java)
![Security](https://img.shields.io/badge/Security-Toolkit-green?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

A comprehensive security tool developed in Java with colored terminal interface and advanced features for security analysis, password management, encryption, and hash generation.

<img width="470" height="283" alt="image" src="https://github.com/user-attachments/assets/2d663a77-dd56-462f-9cf9-52c47de44226" />

## ✨ Key Features

- 🎨 **Colored interface** - Terminal with ANSI colors and modern design
- 🔐 **Multiple algorithms** - MD5, SHA-256, SHA-512, AES encryption/decryption
- 🛡️ **Smart analysis** - Detailed password strength verification with suggestions
- 🎯 **Flexible generation** - Secure and memorable passwords with customization
- 💾 **Auto-saving** - Results logging to files with timestamps
- 🔄 **Hash comparison** - Integrity verification and tampering detection
- 🔒 **AES Cryptography** - Full encryption and decryption capabilities
- 📊 **Detailed reports** - Improvement suggestions and security metrics

## 🚀 Getting Started

### Prerequisites

- Java 8 or higher
- Terminal supporting ANSI colors (Linux, MacOS, Windows Terminal)

### Quick Installation

1. **Download all files to the same directory**

2. **Compile the project:**
other things:
```bash
javac *.java

run: java Main

Project Structure:
security-utils/
├── Main.java                 # Main interface and menu system
├── TerminalUtils.java        # Colored terminal utilities and UI
├── PasswordChecker.java      # Password strength analyzer
├── PasswordGenerator.java    # Secure password generator
├── HashGenerator.java        # Hash generator (MD5, SHA-256, SHA-512)
├── Encryptor.java           # AES encryption and decryption
├── FileManager.java         # File management and auto-saving
├── password_analysis.txt    # Password analysis results (auto-generated)
├── generated_passwords.txt  # Generated passwords log (auto-generated)
├── encrypted_data.txt       # Encryption results (auto-generated)
├── decrypted_data.txt       # Decryption results (auto-generated)
└── README.md               # This file



🛠️ Detailed Features
1. 🔍 Password Strength Analysis
    Length verification: Minimum 8, recommended 12+ characters
    Character diversity: Uppercase, lowercase, numbers, special characters
    Pattern detection: Common sequences and weak patterns
    Scoring system: 0-5 point scale with detailed breakdown
    Improvement suggestions: Specific recommendations to enhance security
    Auto-saving: Optional saving of analysis results to file
2. 🎯 Secure Password Generator
Quick Generate Mode
    Automatic generation: All character types enabled by default
    Recommended length: 16 characters (configurable 4-128)
    Optimal security: Balanced mix of character types
    Strength analysis: Immediate feedback on generated password strength
Custom Generate Mode
    Length control: 4 to 128 characters
    Character type selection:
        Lowercase letters (a-z)
        Uppercase letters (A-Z)
        Numbers (0-9)
        Special characters (!@#$%^&*()_+-=[]{}|;:,.<>?)
    Guaranteed inclusion: At least one of each selected character type
    Secure shuffling: Cryptographically random distribution
3. 🧠 Memorable Password Generator
    Word-based passwords: Combination of common words (2-8 words)
    Hyphen separation: Easy-to-read format (e.g., "sun-mountain-coffee-42")
    Automatic numbers: Random number suffix for added security
    Easy recall: Designed to be memorable yet secure
    Dictionary variety: 27+ common words for diverse combinations
4. 🔐 Hash Generator
Supported Algorithms:
    MD5: Fast hashing (32-character hex output)
        Note: Considered cryptographically broken, use for checksums only
    SHA-256: Secure hashing (64-character hex output)
        Recommended for most security applications
    SHA-512: Maximum security (128-character hex output)
        Slower but most secure option
Features:
    Hexadecimal output: Standard hash representation
    Length display: Hash size information
    Algorithm comparison: Understand trade-offs between different hashes
5. 🔒 AES Encryption
    Symmetric encryption: AES algorithm with 256-bit keys
    Password-based keys: Key derivation using SHA-256
    Base64 encoding: Safe text representation of encrypted data
    Integrity verification: Automatic encryption/decryption validation
    File logging: Optional saving of encrypted data and passwords
    Security warnings: Password safety reminders
6. 🔓 AES Decryption
    Data recovery: Decrypt previously encrypted text
    Password validation: Requires original encryption password
    Error handling: Clear messages for wrong passwords or corrupted data
    Result verification: Confirmation of successful decryption
    File logging: Optional saving of decryption results
7. 📊 Hash Comparator
    Integrity verification: Compare computed hash with provided hash
    Tampering detection: Identify data modification or corruption
    Multiple algorithms: Support for MD5 and SHA-256 comparison
    Clear results: Immediate feedback on hash matching
    Security alerts: Warnings for potential data tampering

⚠️ Security Warnings & Limitations
    MD5 vulnerability: MD5 is cryptographically broken - use for checksums only
    Password length: Always use passwords with at least 12 characters
    Password reuse: Never reuse passwords between different services
    Key management: Keep encryption passwords secure and backed up
    Educational purpose: This tool is for learning and testing only

🔐 Security Best Practices
    Cryptographic randomness: SecureRandom for all random operations
    Key derivation: SHA-256 based key stretching for AES
    Password strength: Multi-factor analysis with practical suggestions
    Hash security: Proper implementation of cryptographic hash functions
    Input validation: Comprehensive error handling and validation

