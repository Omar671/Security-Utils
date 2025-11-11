import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
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
                        compareHashes();
                        break;
                    case 0:
                        TerminalUtils.printSuccess("Thank you for using Security Utils! Goodbye! 👋");
                        return;
                    default:
                        TerminalUtils.printError("Invalid option! Choose between 0-6.");
                }
            } catch (NumberFormatException e) {
                TerminalUtils.printError("Please enter a valid number!");
            }
            
            TerminalUtils.waitForEnter();
            TerminalUtils.printHeader();
        }
    }
    
    private static void testPasswordStrength() {
        TerminalUtils.printSection("PASSWORD STRENGTH ANALYSIS");
        
        System.out.print("Enter password to analyze: ");
        String password = scanner.nextLine();
        
        PasswordChecker.PasswordStrength result = PasswordChecker.analyzePassword(password);
        
        System.out.println("\n" + TerminalUtils.CYAN + "📊 ANALYSIS RESULT:" + TerminalUtils.RESET);
        System.out.println("Password: " + (password.length() > 20 ? password.substring(0, 20) + "..." : password));
        System.out.println("Length: " + password.length() + " characters");
        System.out.println("Score: " + result.score + "/5");
        System.out.println("Strength: " + result.strength);
        
        if (!result.suggestions.isEmpty()) {
            System.out.println("\n💡 IMPROVEMENT SUGGESTIONS:");
            System.out.println(result.suggestions);
        }
        
        System.out.print("\n💾 Save this result? (y/N): ");
        String save = scanner.nextLine().trim().toLowerCase();
        if (save.equals("y") || save.equals("yes")) {
            FileManager.savePasswordResult(password, result);
        }
        
        TerminalUtils.endSection();
    }
    
    private static void generateSecurePassword() {
        TerminalUtils.printSection("SECURE PASSWORD GENERATOR");
        
        System.out.print("Password length (12-32): ");
        int length = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Include lowercase letters? (y/N): ");
        boolean useLower = scanner.nextLine().trim().toLowerCase().startsWith("y");
        
        System.out.print("Include UPPERCASE letters? (y/N): ");
        boolean useUpper = scanner.nextLine().trim().toLowerCase().startsWith("y");
        
        System.out.print("Include numbers? (y/N): ");
        boolean useNumbers = scanner.nextLine().trim().toLowerCase().startsWith("y");
        
        System.out.print("Include special characters? (y/N): ");
        boolean useSpecial = scanner.nextLine().trim().toLowerCase().startsWith("y");
        
        try {
            String password = PasswordGenerator.generatePassword(length, useLower, useUpper, useNumbers, useSpecial);
            
            System.out.println("\n" + TerminalUtils.GREEN + "🔑 PASSWORD GENERATED SUCCESSFULLY!" + TerminalUtils.RESET);
            System.out.println("Password: " + TerminalUtils.CYAN + password + TerminalUtils.RESET);
            System.out.println("Length: " + password.length() + " characters");
            
            PasswordChecker.PasswordStrength analysis = PasswordChecker.analyzePassword(password);
            System.out.println("Strength: " + analysis.strength);
            
            System.out.print("\n💾 Save this password? (y/N): ");
            String save = scanner.nextLine().trim().toLowerCase();
            if (save.equals("y") || save.equals("yes")) {
                FileManager.saveGeneratedPassword(password, "Custom Secure Password");
            }
            
        } catch (IllegalArgumentException e) {
            TerminalUtils.printError(e.getMessage());
        }
        
        TerminalUtils.endSection();
    }
    
    private static void generateMemorablePassword() {
        TerminalUtils.printSection("MEMORABLE PASSWORD GENERATOR");
        
        System.out.print("Number of words (3-5): ");
        int wordCount = Integer.parseInt(scanner.nextLine());
        
        String password = PasswordGenerator.generateMemorablePassword(wordCount);
        
        System.out.println("\n" + TerminalUtils.GREEN + "🧠 MEMORABLE PASSWORD GENERATED!" + TerminalUtils.RESET);
        System.out.println("Password: " + TerminalUtils.CYAN + password + TerminalUtils.RESET);
        System.out.println("Length: " + password.length() + " characters");
        System.out.println("Tip: Easy to remember, still secure!");
        
        System.out.print("\n💾 Save this password? (y/N): ");
        String save = scanner.nextLine().trim().toLowerCase();
        if (save.equals("y") || save.equals("yes")) {
            FileManager.saveGeneratedPassword(password, "Memorable Password");
        }
        
        TerminalUtils.endSection();
    }
    
    private static void generateHash() {
        TerminalUtils.printSection("HASH GENERATOR");
        
        System.out.print("Enter text to hash: ");
        String text = scanner.nextLine();
        
        System.out.println("\nSelect algorithm:");
        System.out.println("1 - MD5 (fast, less secure)");
        System.out.println("2 - SHA-256 (balanced)");
        System.out.println("3 - SHA-512 (slower, more secure)");
        System.out.print("Option (1-3): ");
        
        int algo = Integer.parseInt(scanner.nextLine());
        String hash = "";
        String algoName = "";
        
        switch (algo) {
            case 1:
                hash = HashGenerator.generateMD5(text);
                algoName = "MD5";
                break;
            case 2:
                hash = HashGenerator.generateSHA256(text);
                algoName = "SHA-256";
                break;
            case 3:
                hash = HashGenerator.generateSHA512(text);
                algoName = "SHA-512";
                break;
            default:
                TerminalUtils.printError("Invalid algorithm!");
                return;
        }
        
        System.out.println("\n" + TerminalUtils.GREEN + "🔐 HASH GENERATED:" + TerminalUtils.RESET);
        System.out.println("Algorithm: " + algoName);
        System.out.println("Text: " + text);
        System.out.println("Hash: " + TerminalUtils.CYAN + hash + TerminalUtils.RESET);
        System.out.println("Hash length: " + hash.length() + " characters");
        
        TerminalUtils.endSection();
    }
    
    private static void testEncryption() {
        TerminalUtils.printSection("AES ENCRYPTION");
        
        System.out.print("Enter text to encrypt: ");
        String text = scanner.nextLine();
        
        System.out.print("Enter encryption password: ");
        String password = scanner.nextLine();
        
        try {
            String encrypted = Encryptor.encrypt(text, password);
            String decrypted = Encryptor.decrypt(encrypted, password);
            
            System.out.println("\n" + TerminalUtils.GREEN + "🔄 ENCRYPTION SUCCESSFUL!" + TerminalUtils.RESET);
            System.out.println("Original text: " + text);
            System.out.println("Encrypted text: " + TerminalUtils.CYAN + encrypted + TerminalUtils.RESET);
            System.out.println("Decrypted text: " + decrypted);
            System.out.println("✅ Verification: " + (text.equals(decrypted) ? "SUCCESS" : "FAILED"));
            
        } catch (Exception e) {
            TerminalUtils.printError("Encryption error: " + e.getMessage());
        }
        
        TerminalUtils.endSection();
    }
    
    private static void compareHashes() {
        TerminalUtils.printSection("HASH COMPARATOR");
        
        System.out.print("Enter original text: ");
        String text = scanner.nextLine();
        
        System.out.print("Enter hash to compare: ");
        String hashToCompare = scanner.nextLine();
        
        System.out.println("\nSelect hash algorithm:");
        System.out.println("1 - MD5");
        System.out.println("2 - SHA-256");
        System.out.print("Option (1-2): ");
        
        int algo = Integer.parseInt(scanner.nextLine());
        String newHash = "";
        
        switch (algo) {
            case 1:
                newHash = HashGenerator.generateMD5(text);
                break;
            case 2:
                newHash = HashGenerator.generateSHA256(text);
                break;
            default:
                TerminalUtils.printError("Invalid algorithm!");
                return;
        }
        
        System.out.println("\n" + TerminalUtils.CYAN + "🔍 HASH COMPARISON:" + TerminalUtils.RESET);
        System.out.println("Provided hash: " + hashToCompare);
        System.out.println("Calculated hash: " + newHash);
        
        if (newHash.equalsIgnoreCase(hashToCompare)) {
            TerminalUtils.printSuccess("✅ HASHES MATCH! Authentication valid.");
        } else {
            TerminalUtils.printError("🚨 HASHES DON'T MATCH! Possible tampering.");
        }
        
        TerminalUtils.endSection();
    }
}