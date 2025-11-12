import java.util.regex.Pattern;

/**
 * PasswordChecker class for analyzing password strength.
 * Updated for Java 21 with improved code structure and documentation.
 */
public class PasswordChecker {
    
    public static class PasswordStrength {
        public int score;
        public String strength;
        public String suggestions;
    }
    
    public static PasswordStrength analyzePassword(String password) {
        PasswordStrength result = new PasswordStrength();
        StringBuilder suggestions = new StringBuilder();
        int score = 0;
        
        if (password == null || password.isEmpty()) {
            result.score = 0;
            result.strength = "EMPTY";
            result.suggestions = "Enter a password";
            return result;
        }
        
        if (password.length() >= 12) {
            score += 2;
        } else if (password.length() >= 8) {
            score += 1;
            suggestions.append(" Use at least 12 characters\n");
        } else {
            suggestions.append(" Password too short (minimum 8 characters)\n");
        }
        
        if (Pattern.compile("[A-Z]").matcher(password).find()) {
            score++;
        } else {
            suggestions.append(" Add UPPERCASE letters\n");
        }
        
        if (Pattern.compile("[a-z]").matcher(password).find()) {
            score++;
        } else {
            suggestions.append(" Add lowercase letters\n");
        }
        
        if (Pattern.compile("[0-9]").matcher(password).find()) {
            score++;
        } else {
            suggestions.append(" Add NUMBERS\n");
        }
        
        if (Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]").matcher(password).find()) {
            score++;
        } else {
            suggestions.append(" Add SPECIAL CHARACTERS (!@#$...)\n");
        }
        
        if (Pattern.compile("(123|abc|qwert|asdf)").matcher(password.toLowerCase()).find()) {
            score--;
            suggestions.append(" Avoid common sequences\n");
        }
        
        if (score >= 5) {
            result.strength = "  VERY STRONG";
        } else if (score >= 4) {
            result.strength = "  STRONG";
        } else if (score >= 3) {
            result.strength = "   MEDIUM";
        } else {
            result.strength = "  WEAK";
        }
        
        result.score = score;
        result.suggestions = suggestions.toString();
        return result;
    }
}
