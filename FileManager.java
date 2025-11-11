import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {
    
    public static void saveToFile(String filename, String content) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println("=== " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + " ===");
            writer.println(content);
            writer.println("=".repeat(50));
            writer.println();
        }
    }
    
    public static void savePasswordResult(String password, PasswordChecker.PasswordStrength result) {
        try {
            String content = "Analyzed password: " + password + "\n" +
                           "Score: " + result.score + "/5\n" +
                           "Strength: " + result.strength + "\n" +
                           "Suggestions:\n" + result.suggestions;
            saveToFile("password_analysis.txt", content);
            TerminalUtils.printSuccess("Result saved to password_analysis.txt");
        } catch (IOException e) {
            TerminalUtils.printError("Error saving file: " + e.getMessage());
        }
    }
    
    public static void saveGeneratedPassword(String password, String type) {
        try {
            String content = "Type: " + type + "\n" +
                           "Generated password: " + password + "\n" +
                           "Length: " + password.length() + " characters\n" +
                           "Timestamp: " + LocalDateTime.now();
            saveToFile("generated_passwords.txt", content);
            TerminalUtils.printSuccess("Password saved to generated_passwords.txt");
        } catch (IOException e) {
            TerminalUtils.printError("Error saving file: " + e.getMessage());
        }
    }
}