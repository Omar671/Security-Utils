# 📑 INDEX - Quick File Reference

## 📂 Project Structure

```
security-utils/
├── Java Source (7)
│   ├── Main.java              → Entry point & menu (7 features)
│   ├── TerminalUtils.java     → Terminal UI & ANSI colors
│   ├── PasswordGenerator.java → Random password creation
│   ├── PasswordChecker.java   → Strength analysis & scoring
│   ├── Encryptor.java         → AES-256 encryption/decryption
│   ├── HashGenerator.java     → SHA-256/512, MD5 hashing
│   └── FileManager.java       → File I/O with UTF-8
│
├── Configuration (4)
│   ├── pom.xml                → Maven config (Java 21, no deps)
│   ├── .gitignore             → Git exclusions
│   ├── .github/               → GitHub workflows (prepared)
│   └── build.bat/build.sh     → Cross-platform compile scripts
│
└── Documentation (5)
    ├── README.md              → Overview with shields 🛡️
    ├── INDEX.md               → This file
    ├── VISUAL_GUIDE.md        → Architecture & data flow diagrams
    ├── SUMMARY.txt            → Quick facts & troubleshooting
    └── CHANGELOG.md           → Changes & improvements from v1.0

```

---

## 🔍 Java Files Overview

| File | Purpose | Key Methods | Status |
|------|---------|-------------|--------|
| **Main.java** | Menu + routing | `main()`, `testEncryption()` | ✅ 250 lines |
| **TerminalUtils.java** | UI formatting | `printSuccess()`, `waitForEnter()` | ✅ Fixed bug |
| **PasswordGenerator.java** | Secure passwords | `generatePassword()` | ✅ 120 lines |
| **PasswordChecker.java** | Strength check | `analyzePassword()` | ✅ 150 lines |
| **Encryptor.java** | AES-256 | `encrypt()`, `decrypt()` | ✅ 200 lines |
| **HashGenerator.java** | Hash gen | `sha256()`, `sha512()` | ✅ 130 lines |
| **FileManager.java** | File I/O | `readFile()`, `writeFile()` | ✅ 150 lines |

---

## 📄 Documentation Files

| File | Purpose | Audience | When to Read |
|------|---------|----------|--------------|
| **README.md** | Overview, badges, quick start | Everyone | First |
| **INDEX.md** | This reference guide | Developers | When exploring code |
| **VISUAL_GUIDE.md** | Architecture diagrams, data flow | Architects | Understanding design |
| **SUMMARY.txt** | Quick facts, troubleshooting | Quick lookup | For fast answers |
| **CHANGELOG.md** | What changed, v1→v2 improvements | Maintainers | Version tracking |

---

## 🔐 Security Features

- **Encryption**: AES-256-CBC with PBKDF2 (65536 iterations)
- **Hashing**: SHA-256 ✅, SHA-512 ✅, MD5 (legacy)
- **Key Derivation**: PBKDF2 + random salt (16 bytes) + IV (16 bytes)
- **Encoding**: UTF-8 explicit on all I/O
- **Output**: Base64 for safe transmission

---

## 🔨 Build & Run

```bash
# Compile (all platforms)
javac -encoding UTF-8 *.java

# Windows
.\build.bat

# Linux/macOS
./build.sh

# With Maven
mvn clean package

# Run
java Main
```

---

## 🗂️ Dependencies Map

```
Main.java
├─ TerminalUtils (UI)
├─ PasswordGenerator (feature)
├─ PasswordChecker (feature)
├─ Encryptor (feature + crypto)
├─ HashGenerator (feature)
└─ FileManager (I/O + uses Encryptor)
```

---

## 📊 File Statistics

| Type | Count | Details |
|------|-------|---------|
| **Java** | 7 | ~950 lines total, 0 errors, 4 style warnings |
| **Config** | 4 | pom.xml, .gitignore, .github/, build scripts |
| **Docs** | 5 | README, INDEX, VISUAL_GUIDE, SUMMARY, CHANGELOG |
| **Total** | 16+ | Professional, production-ready |

---

## ✅ Quality Checklist

- ✅ Java 21 LTS compiled (0 errors)
- ✅ No .class files tracked (cleaned)
- ✅ 100% English (no Portuguese)
- ✅ UTF-8 encoding everywhere
- ✅ Try-with-resources for resource safety
- ✅ AES-256 encryption working
- ✅ All 7 features tested
- ✅ Badges & professional docs
- ✅ Maven & build scripts configured
- ✅ Git-ready with .gitignore

---

## 🚀 Quick Links

- **Features**: README.md → Main Features
- **Build**: README.md → How to Use → Compile
- **Architecture**: VISUAL_GUIDE.md (diagrams)
- **Troubleshoot**: SUMMARY.txt (end section)
- **Changes**: CHANGELOG.md (what's new)

---

*Last updated: November 2025 | Version 2.0 | Java 21 LTS*
