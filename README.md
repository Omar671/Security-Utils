# 🔒 Security Utils - Java Security Toolkit

![Java](https://img.shields.io/badge/Java-8+-blue?style=for-the-badge&logo=java)
![Security](https://img.shields.io/badge/Security-Toolkit-green?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

A comprehensive security tool developed in Java with colored terminal interface and advanced features for security analysis, password management, encryption, and hash generation.

<img width="470" height="283" alt="Security Utils Terminal Interface" src="https://github.com/user-attachments/assets/2d663a77-dd56-462f-9cf9-52c47de44226" />

## ✨ Key Features

- 🎨 **Colored interface** - Terminal with ANSI colors and modern design
- 🔐 **Multiple algorithms** - MD5, SHA-256, SHA-512, AES encryption/decryption
- 🛡️ **Smart analysis** - Detailed password strength verification with suggestions
- 🎯 **Flexible generation** - Secure and memorable passwords with customization
- 💾 **Auto-saving** - Results logging to files with timestamps
- 🔄 **Hash comparison** - Integrity verification and tampering detection
- 🔒 **AES Cryptography** - Full encryption and decryption capabilities

## 🚀 Quick Start

### Prerequisites
- Java 8 or higher
- Terminal supporting ANSI colors

### Installation
```bash
# Clone and compile
git clone <repository-url>
cd security-utils
javac *.java

# Run the application
java Main
```

## 📁 Project Structure

```
security-utils/
├── Main.java                 # Main interface and menu system
├── TerminalUtils.java        # Colored terminal utilities
├── PasswordChecker.java      # Password strength analyzer
├── PasswordGenerator.java    # Secure password generator
├── HashGenerator.java        # Hash generator
├── Encryptor.java           # AES encryption/decryption
├── FileManager.java         # File management
└── *.txt                   # Auto-generated output files
```

## 🛠️ Features Overview

### 1. 🔍 Password Strength Analysis
- Length verification (8+ characters recommended)
- Character diversity analysis
- 0-5 scoring system with improvement suggestions
- Pattern detection for common weak passwords

### 2. 🎯 Password Generation
**Quick Generate:**
- All character types enabled
- 16-character recommended length (4-128 range)
- Instant strength feedback

**Custom Generate:**
- Select character types: lowercase, uppercase, numbers, special
- Guaranteed inclusion of selected types
- Secure random shuffling

### 3. 🧠 Memorable Passwords
- Word combinations (2-8 words)
- Hyphen-separated format
- Random number suffixes
- 27+ word dictionary

### 4. 🔐 Hash Generation
- **MD5** - Fast (32-character hex)
- **SHA-256** - Secure (64-character hex) 
- **SHA-512** - Maximum security (128-character hex)

### 5. 🔒 AES Encryption/Decryption
- Symmetric encryption with 256-bit keys
- Password-based key derivation (SHA-256)
- Base64 encoded output
- Integrity verification

### 6. 📊 Hash Comparison
- Data integrity verification
- Tampering detection
- MD5 and SHA-256 support
- Clear match/mismatch results

## ⚠️ Security Notes

### Best Practices
- Uses `SecureRandom` for cryptographic randomness
- SHA-256 key derivation for AES
- Comprehensive input validation
- Multi-factor password analysis

### Limitations
- **MD5**: Cryptographically broken - use for checksums only
- **Educational purpose**: For learning and testing
- Always use 12+ character passwords
- Never reuse passwords across services

## 🚧 Future Enhancements

- BCrypt/Argon2 support
- Password breach checking
- Graphical interface
- File hashing capabilities
- Multi-factor authentication

---

<div align="center">

**⭐ See you in the future. 🚀 ⭐**

</div>
