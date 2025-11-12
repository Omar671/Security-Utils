# 🔒 Security Utils v2.0

[![Java](https://img.shields.io/badge/Java-21%20LTS-blue?style=flat-square&logo=java)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.9+-success?style=flat-square&logo=apache-maven)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green?style=flat-square)](LICENSE)
[![Status](https://img.shields.io/badge/Status-Production%20Ready-brightgreen?style=flat-square)](https://github.com)
[![Encryption](https://img.shields.io/badge/Encryption-AES--256-red?style=flat-square&logo=security)](https://en.wikipedia.org/wiki/Advanced_Encryption_Standard)
[![Security](https://img.shields.io/badge/Security-SHA--256%2FSHA--512-orange?style=flat-square)](https://en.wikipedia.org/wiki/SHA-2)

<img width="456" height="295" alt="image" src="https://github.com/user-attachments/assets/c20f3654-3ca7-42de-8f7e-48eed5f49755" />

A comprehensive security toolkit in Java 21, featuring password generator, password strength checker, AES-256 encryption, hash generator, and much more!

## ✨ Main Features

### 🔐 Password Generator
- **Quick Generate**: Secure passwords with recommended settings (12-32 characters)
- **Custom Generate**: Choose character types to include (lowercase, uppercase, numbers, special)
- **Memorable Password**: Easy-to-remember passwords using words

### 🔑 Password Strength Checker
- Complete strength analysis (1-5 stars)
- Personalized improvement suggestions
- Security requirement validation

### 🔓 Encryption & Decryption
- **AES-256** encryption with secure key derivation (PBKDF2)
- Support for text of any size
- Save/load encrypted data

### #️⃣ Hash Generator
- Support for **MD5**, **SHA-256**, and **SHA-512**
- Fast and reliable generation
- Hash comparison with validation

### 💾 File Manager
- Save generated password results
- Store encrypted/decrypted data
- Save strength analysis results

## 🚀 How to Use

### Compile
```bash
# Windows
.\build.bat

# Linux/macOS
./build.sh

# Or manually with javac
javac *.java

# Or with Maven
mvn clean package
```

### Run
```bash
java Main
```

### Main Menu
```
1 - Check password strength
2 - Generate custom password
3 - Generate memorable password
4 - Generate hash (MD5/SHA-256/SHA-512)
5 - AES encryption
6 - AES decryption
7 - Compare hashes
0 - Exit
```

## 📋 Requirements

[![Java](https://img.shields.io/badge/Requires-Java%2021%20LTS-blue?style=flat-square&logo=java)](https://www.oracle.com/java/technologies/javase/jdk21-archive.html)
[![Build](https://img.shields.io/badge/Build-Maven%203.9%2B-success?style=flat-square&logo=apache-maven)](https://maven.apache.org/)
[![Platform](https://img.shields.io/badge/Platform-Windows%20%7C%20Linux%20%7C%20macOS-informational?style=flat-square)](https://en.wikipedia.org/wiki/Cross-platform)
[![UTF-8](https://img.shields.io/badge/Encoding-UTF--8-green?style=flat-square)](https://en.wikipedia.org/wiki/UTF-8)

- **Java 21 LTS** or higher
- Maven 3.9+ (optional, for build)

## 📁 Project Structure

```
security-utils/
├── Main.java                 # Application entry point + menu
├── Encryptor.java           # AES-256 encryption
├── FileManager.java         # File management
├── HashGenerator.java       # Hash generation
├── PasswordChecker.java     # Password strength analysis
├── PasswordGenerator.java   # Password generator
├── TerminalUtils.java       # Terminal utilities (ANSI colors)
├── pom.xml                  # Maven configuration
├── build.bat                # Build script (Windows)
├── build.sh                 # Build script (Linux/macOS)
├── .gitignore               # Ignore unnecessary files
└── README.md                # This file
```

## 🔧 Technical Features

### AES-256 Encryption
- Algorithm: AES with CBC mode
- Key size: 256 bits
- Key derivation: PBKDF2 with SHA-256
- Iterations: 10,000

### Hashing
- **MD5**: Fast, for non-cryptographic purposes
- **SHA-256**: Recommended for passwords
- **SHA-512**: Maximum security

### Password Strength Verification
Scoring based on:
- ✅ Minimum length (8+ characters)
- ✅ Lowercase inclusion
- ✅ Uppercase inclusion
- ✅ Number inclusion
- ✅ Special character inclusion

## 📊 Usage Examples

### Check Password Strength
```
Enter password to analyze: MySecurePass123!
📊 ANALYSIS RESULT:
Length: 17 characters
Score: 5/5
Strength: ⭐⭐⭐⭐⭐ VERY STRONG
```

### Generate Secure Password
```
Password length (12-32): 16
🔑 PASSWORD GENERATED SUCCESSFULLY!
Password: [generated password]
Strength: ⭐⭐⭐⭐⭐ VERY STRONG
```

### AES Encryption
```
Enter text to encrypt: Secret message
Enter encryption password: MyPassword123
🔒 ENCRYPTION SUCCESSFUL!
Encrypted text: [encoded-data]
Auto-verification: ✅ SUCCESS
```

## 🛡️ Security

- ✅ Military-grade AES-256 encryption
- ✅ PBKDF2 key derivation
- ✅ Full Unicode (UTF-8) support
- ✅ No external dependencies
- ✅ Modernized with Java 21

## 📝 Recent Improvements (v2.0)

- ✅ Migration to Java 21 LTS
- ✅ Refactored `waitForEnter()` - menu works correctly
- ✅ Code cleanup and warning reduction
- ✅ StandardCharsets (UTF-8) support
- ✅ Improved try-with-resources
- ✅ Terminal with ANSI colors

## 👨‍💻 Technologies

[![Java](https://img.shields.io/badge/Language-Java%2021%20LTS-blue?style=flat-square&logo=java)](https://www.oracle.com/java/)
[![Build](https://img.shields.io/badge/Build%20Tool-Maven%203.9-success?style=flat-square&logo=apache-maven)](https://maven.apache.org/)
[![Crypto](https://img.shields.io/badge/Crypto-AES--256%2FCBC-red?style=flat-square&logo=security)](https://en.wikipedia.org/wiki/Advanced_Encryption_Standard)
[![Hash](https://img.shields.io/badge/Hash-SHA--256%2FSHA--512%2FMD5-orange?style=flat-square&logo=security)](https://en.wikipedia.org/wiki/SHA-2)
[![Security](https://img.shields.io/badge/Key%20Derivation-PBKDF2-critical?style=flat-square&logo=security)](https://en.wikipedia.org/wiki/PBKDF2)
[![Format](https://img.shields.io/badge/Encoding-UTF--8-green?style=flat-square&logo=unicode)](https://en.wikipedia.org/wiki/UTF-8)

- **Language**: Java 21 LTS
- **Build**: Maven 3.9.11
- **Encryption**: javax.crypto (AES)
- **Hashing**: java.security (MD5, SHA-256, SHA-512)

## 📜 License

MIT License - Free to use in your projects!

---

**🔒 Keep your data secure!**  
*Last updated: November 2025*

