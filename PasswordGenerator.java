import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PasswordGenerator class for generating secure and memorable passwords.
 * Updated for Java 21 with improved code structure and documentation.
 */
public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()_+-=[]{}|;:,.<>?";
    
    private static final SecureRandom random = new SecureRandom();
    
    public static String generatePassword(int length, boolean useLower, boolean useUpper, 
                                         boolean useNumbers, boolean useSpecial) {
        if (length < 12) {
            throw new IllegalArgumentException("Password must have at least 12 characters");
        }
        
        StringBuilder allChars = new StringBuilder();
        if (useLower) allChars.append(LOWERCASE);
        if (useUpper) allChars.append(UPPERCASE);
        if (useNumbers) allChars.append(NUMBERS);
        if (useSpecial) allChars.append(SPECIAL);
        
        if (allChars.length() == 0) {
            throw new IllegalArgumentException("Select at least one character type");
        }
        
        List<Character> password = new ArrayList<>();
        
        if (useLower) password.add(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        if (useUpper) password.add(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        if (useNumbers) password.add(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        if (useSpecial) password.add(SPECIAL.charAt(random.nextInt(SPECIAL.length())));
        
        for (int i = password.size(); i < length; i++) {
            password.add(allChars.charAt(random.nextInt(allChars.length())));
        }
        
        Collections.shuffle(password, random);
        
        StringBuilder result = new StringBuilder();
        for (Character c : password) {
            result.append(c);
        }
        
        return result.toString();
    }
    
    public static String generateMemorablePassword(int wordCount) {
        String[] words = {"red", "blue", "green", "yellow", "cat", "dog", 
                         "house", "sun", "moon", "star", "computer", "java", 
                         "security", "password", "strong", "crypto"};
        
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < wordCount; i++) {
            if (i > 0) password.append("-");
            password.append(words[random.nextInt(words.length)]);
        }
        
        password.append(random.nextInt(100));
        
        return password.toString();
    }
}
