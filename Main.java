import java.util.Scanner;

/**
 * Main class for the Security Utils application.
 * Updated for Java 21 with enhanced resource management.
 * Fixed: Removed module-info requirements, corrected switch statements.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        TerminalUtils.printHeader();
        
        while (true) {
            TerminalUtils.printMenu();
            String input = scanner.nextLine().trim();
            
            try {
                int choice = Integer.parseInt(input);
                
                switch (choice) {
                    case 1:
                        testPasswordStrength();
                        break;
                    case 2:
                        generateSecurePassword();
                        break;
                    case 3:
                        generateMemorablePassword();
                        break;
                    case 4:
                        generateHash();
                        break;
                    case 5:
                        testEncryption();
                        break;
                    case 6:
                        testDecryption();
                        break;
                    case 7:
                        compareHashes();
                        break;
                    case 0:
                        TerminalUtils.printSuccess("Thank you for using Security Utils! Goodbye.");
                        return;
                    default:
                        TerminalUtils.printError("Invalid option! Choose between 0-7.");
                }
            } catch (NumberFormatException e) {
                TerminalUtils.printError("Please enter a valid number!");
            }
            
            TerminalUtils.waitForEnter(scanner);
            TerminalUtils.printHeader();
        }
    }
    
    private static void testPasswordStrength() {
        TerminalUtils.printSection("PASSWORD STRENGTH ANALYZER");
        
        System.out.print("  [?] Enter password to analyze: ");
        String password = scanner.nextLine();
        
        PasswordChecker.PasswordStrength result = PasswordChecker.analyzePassword(password);
        
        System.out.println("\n" + TerminalUtils.BOLD_CYAN + "  [ANALYSIS REPORT]" + TerminalUtils.RESET);
        System.out.println("  Password Length: " + password.length() + " chars");
        System.out.println("  Strength Score: " + result.score + "/5");
        System.out.println("  Classification: " + result.strength);
        
        if (!result.suggestions.isEmpty()) {
            System.out.println("\n" + TerminalUtils.YELLOW + "  [IMPROVEMENT SUGGESTIONS]" + TerminalUtils.RESET);
            System.out.println("  " + result.suggestions);
        }
        
        System.out.print("\n  Save result to file? (y/n): ");
        String save = scanner.nextLine().trim().toLowerCase();
        if (save.equals("y") || save.equals("yes")) {
            FileManager.savePasswordResult(password, result);
            TerminalUtils.printSuccess("Result saved successfully");
        }
        
        TerminalUtils.endSection();
    }
    
    private static void generateSecurePassword() {
        TerminalUtils.printSection("SECURE PASSWORD GENERATOR");
        
        System.out.println("  [*] Select generation mode:");
        System.out.println("  [1] Quick Generate (recommended settings)");
        System.out.println("  [2] Custom Generate (choose character types)");
        System.out.print("  [?] Select option (1-2): ");
        
        String modeChoice = scanner.nextLine().trim();
        
        if ("1".equals(modeChoice)) {
            generateQuickPassword();
        } else if ("2".equals(modeChoice)) {
            generateCustomPassword();
        } else {
            TerminalUtils.printError("Invalid option selected. Using quick generate.");
            generateQuickPassword();
        }
    }
    
    private static void generateQuickPassword() {
        System.out.print("  [?] Password length (12-32, recommended 16): ");
        int length;
        try {
            length = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            TerminalUtils.printWarning("Invalid length. Using default: 16");
            length = 16;
        }
        
        if (length < 12 || length > 32) {
            TerminalUtils.printWarning("Length out of range (12-32). Using: 16");
            length = 16;
        }
        
        String password = PasswordGenerator.generatePassword(length, true, true, true, true);
        
        TerminalUtils.printSuccess("PASSWORD GENERATED - Ready to use");
        System.out.println("  Generated: " + TerminalUtils.GREEN + password + TerminalUtils.RESET);
        System.out.println("  Length: " + password.length() + " characters");
        System.out.println("  Charset: Lowercase + Uppercase + Numbers + Special");
        
        PasswordChecker.PasswordStrength analysis = PasswordChecker.analyzePassword(password);
        System.out.println("  Strength: " + analysis.strength);
        
        System.out.print("\n  Save generated password? (y/n): ");
        String save = scanner.nextLine().trim().toLowerCase();
        if (save.equals("y") || save.equals("yes")) {
            FileManager.saveGeneratedPassword(password, "Quick Secure Password");
            TerminalUtils.printSuccess("Password saved to file");
        }
        
        TerminalUtils.endSection();
    }
    
    private static void generateCustomPassword() {
        TerminalUtils.printSection("CUSTOM PASSWORD GENERATOR");
        
        System.out.print("  [?] Password length (12-32): ");
        int length = Integer.parseInt(scanner.nextLine());
        
        System.out.print("  [?] Include lowercase letters? (y/N): ");
        boolean useLower = scanner.nextLine().trim().toLowerCase().startsWith("y");
        
        System.out.print("  [?] Include UPPERCASE letters? (y/N): ");
        boolean useUpper = scanner.nextLine().trim().toLowerCase().startsWith("y");
        
        System.out.print("  [?] Include numbers? (y/N): ");
        boolean useNumbers = scanner.nextLine().trim().toLowerCase().startsWith("y");
        
        System.out.print("  [?] Include special characters? (y/N): ");
        boolean useSpecial = scanner.nextLine().trim().toLowerCase().startsWith("y");
        
        try {
            String password = PasswordGenerator.generatePassword(length, useLower, useUpper, useNumbers, useSpecial);
            
            TerminalUtils.printSuccess("PASSWORD GENERATED SUCCESSFULLY");
            System.out.println("  Generated: " + TerminalUtils.GREEN + password + TerminalUtils.RESET);
            System.out.println("  Length: " + password.length() + " characters");
            
            StringBuilder settings = new StringBuilder("  Charset: ");
            if (useLower) settings.append("lowercase ");
            if (useUpper) settings.append("UPPERCASE ");
            if (useNumbers) settings.append("numbers ");
            if (useSpecial) settings.append("special-chars");
            System.out.println(settings.toString());
            
            PasswordChecker.PasswordStrength analysis = PasswordChecker.analyzePassword(password);
            System.out.println("  Strength: " + analysis.strength + " (" + analysis.score + "/5)");
            
            System.out.print("\n  Save this password? (y/n): ");
            String save = scanner.nextLine().trim().toLowerCase();
            if (save.equals("y") || save.equals("yes")) {
                FileManager.saveGeneratedPassword(password, "Custom Secure Password");
                TerminalUtils.printSuccess("Password saved successfully");
            }
            
        } catch (IllegalArgumentException e) {
            TerminalUtils.printError(e.getMessage());
        }
        
        TerminalUtils.endSection();
    }
    private static void generateMemorablePassword() {
        TerminalUtils.printSection("MEMORABLE PASSWORD GENERATOR");
        
        System.out.print("  [?] Number of words (3-5): ");
        int wordCount = Integer.parseInt(scanner.nextLine());
        
        String password = PasswordGenerator.generateMemorablePassword(wordCount);
        
        TerminalUtils.printSuccess("MEMORABLE PASSWORD GENERATED");
        System.out.println("  Generated: " + TerminalUtils.GREEN + password + TerminalUtils.RESET);
        System.out.println("  Length: " + password.length() + " characters");
        System.out.println("  Type: Passphrase (easy to remember, strong)");
        
        PasswordChecker.PasswordStrength analysis = PasswordChecker.analyzePassword(password);
        System.out.println("  Strength: " + analysis.strength + " (" + analysis.score + "/5)");
        System.out.println("  Tip: Easy to remember, still secure for most uses");
        
        System.out.print("\n  Save this password? (y/n): ");
        String save = scanner.nextLine().trim().toLowerCase();
        if (save.equals("y") || save.equals("yes")) {
            FileManager.saveGeneratedPassword(password, "Memorable Password");
            TerminalUtils.printSuccess("Password saved successfully");
        }
        
        TerminalUtils.endSection();
    }
    
    private static void generateHash() {
        TerminalUtils.printSection("HASH GENERATOR - CRYPTOGRAPHIC");
        
        System.out.print("  [?] Enter text to hash: ");
        String text = scanner.nextLine();
        
        System.out.println("\n  [*] Available algorithms:");
        System.out.println("  [1] MD5 (legacy, not recommended)");
        System.out.println("  [2] SHA-256 (balanced, recommended)");
        System.out.println("  [3] SHA-512 (maximum security)");
        System.out.print("  [?] Select algorithm (1-3): ");
        
        int algo = Integer.parseInt(scanner.nextLine());
        
        // Show loading animation
        TerminalUtils.showLoadingAnimation("Computing hash...", 800);
        
        String hash = null;
        switch (algo) {
            case 1:
                hash = HashGenerator.generateMD5(text);
                break;
            case 2:
                hash = HashGenerator.generateSHA256(text);
                break;
            case 3:
                hash = HashGenerator.generateSHA512(text);
                break;
            default:
                hash = null;
        }

        String algoName;
        switch (algo) {
            case 1:
                algoName = "MD5";
                break;
            case 2:
                algoName = "SHA-256";
                break;
            case 3:
                algoName = "SHA-512";
                break;
            default:
                algoName = "UNKNOWN";
        }
        
        if (hash == null) {
            TerminalUtils.printError("Invalid algorithm selected");
            TerminalUtils.endSection();
            return;
        }
        
        TerminalUtils.printSuccess("HASH COMPUTED SUCCESSFULLY");
        System.out.println("  Algorithm: " + algoName);
        System.out.println("  Input: " + (text.length() > 30 ? text.substring(0, 30) + "..." : text));
        System.out.println("  Hash: " + TerminalUtils.GREEN + hash + TerminalUtils.RESET);
        System.out.println("  Length: " + hash.length() + " hex characters");
        
        TerminalUtils.endSection();
    }
    
    private static void testEncryption() {
        TerminalUtils.printSection("AES-256 ENCRYPTION [CBC MODE]");
        
        System.out.print("  [?] Enter text to encrypt: ");
        String text = scanner.nextLine();
        
        System.out.print("  [?] Enter encryption password: ");
        String password = scanner.nextLine();
        
        // Show loading animation
        TerminalUtils.showLoadingAnimation("Encrypting data with AES-256...", 1200);
        
        try {
            String encrypted = Encryptor.encrypt(text, password);
            
            TerminalUtils.printSuccess("ENCRYPTION COMPLETED");
            System.out.println("  Original Length: " + text.length() + " bytes");
            System.out.println("  Encrypted: " + TerminalUtils.GREEN + encrypted.substring(0, Math.min(50, encrypted.length())) + "..." + TerminalUtils.RESET);
            
            // Auto-verification test
            String decrypted = Encryptor.decrypt(encrypted, password);
            System.out.println("  Integrity Check: " + (text.equals(decrypted) ? TerminalUtils.GREEN + "VERIFIED" : TerminalUtils.RED + "FAILED") + TerminalUtils.RESET);
            
            System.out.print("\n  Save encrypted data to file? (y/n): ");
            String save = scanner.nextLine().trim().toLowerCase();
            if (save.equals("y") || save.equals("yes")) {
                String content = "ENCRYPTED DATA\n" + "=".repeat(40) + "\n" +
                               "Original: " + text + "\n" +
                               "Password: " + password + "\n" +
                               "Encrypted: " + encrypted + "\n" +
                               "Timestamp: " + java.time.LocalDateTime.now();
                FileManager.saveToFile("encrypted_data.txt", content);
                TerminalUtils.printSuccess("Data saved to encrypted_data.txt");
            }
            
        } catch (Exception e) {
            TerminalUtils.printError("Encryption failed: " + e.getMessage());
        }
        
        TerminalUtils.endSection();
    }
    
    private static void testDecryption() {
        TerminalUtils.printSection("AES-256 DECRYPTION [CBC MODE]");
        
        System.out.print("  [?] Enter encrypted text: ");
        String encrypted = scanner.nextLine();
        
        System.out.print("  [?] Enter decryption password: ");
        String password = scanner.nextLine();
        
        // Show loading animation
        TerminalUtils.showLoadingAnimation("Decrypting data with AES-256...", 1200);
        
        try {
            String decrypted = Encryptor.decrypt(encrypted, password);
            
            TerminalUtils.printSuccess("DECRYPTION COMPLETED");
            System.out.println("  Encrypted Length: " + encrypted.length() + " bytes");
            System.out.println("  Decrypted: " + TerminalUtils.GREEN + decrypted + TerminalUtils.RESET);
            System.out.println("  Confidence: " + (decrypted.length() > 0 ? "HIGH" : "MEDIUM"));
            
            System.out.print("\n  Save decrypted data to file? (y/n): ");
            String save = scanner.nextLine().trim().toLowerCase();
            if (save.equals("y") || save.equals("yes")) {
                String content = "DECRYPTED DATA\n" + "=".repeat(40) + "\n" +
                               "Encrypted: " + encrypted + "\n" +
                               "Decrypted: " + decrypted + "\n" +
                               "Timestamp: " + java.time.LocalDateTime.now();
                FileManager.saveToFile("decrypted_data.txt", content);
                TerminalUtils.printSuccess("Data saved to decrypted_data.txt");
            }
            
        } catch (javax.crypto.BadPaddingException e) {
            TerminalUtils.printError("Wrong password or corrupted data");
        } catch (Exception e) {
            TerminalUtils.printError("Decryption failed: " + e.getMessage());
        }
        
        TerminalUtils.endSection();
    }
    
    private static void compareHashes() {
        TerminalUtils.printSection("HASH COMPARATOR - VERIFICATION");
        
        System.out.print("  [?] Enter original text: ");
        String text = scanner.nextLine();
        
        System.out.print("  [?] Enter hash to compare: ");
        String hashToCompare = scanner.nextLine();
        
        System.out.println("\n  [*] Select hash algorithm:");
        System.out.println("  [1] MD5");
        System.out.println("  [2] SHA-256");
        System.out.print("  [?] Select algorithm (1-2): ");
        
        int algo = Integer.parseInt(scanner.nextLine());
        
        // Show loading animation
        TerminalUtils.showLoadingAnimation("Comparing hashes...", 800);
        
        String newHash = null;
        switch (algo) {
            case 1:
                newHash = HashGenerator.generateMD5(text);
                break;
            case 2:
                newHash = HashGenerator.generateSHA256(text);
                break;
            default:
                newHash = null;
        }
        
        if (newHash == null) {
            TerminalUtils.printError("Invalid algorithm");
            TerminalUtils.endSection();
            return;
        }
        
        System.out.println("\n" + TerminalUtils.BOLD_CYAN + "  [COMPARISON RESULT]" + TerminalUtils.RESET);
        System.out.println("  Input Hash: " + hashToCompare);
        System.out.println("  Computed: " + newHash);
        
        if (newHash.equalsIgnoreCase(hashToCompare)) {
            TerminalUtils.printSuccess("MATCH - Authentication verified");
        } else {
            TerminalUtils.printError("MISMATCH - Possible tampering detected");
        }
        
        TerminalUtils.endSection();
    }
}
