/**
 * TerminalUtils class for terminal output formatting and styling.
 * Updated for Java 21 with ANSI color codes and improved formatting.
 */
public class TerminalUtils {
    
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    
    // Bold colors for stronger contrast
    public static final String BOLD = "\u001B[1m";
    public static final String BOLD_CYAN = BOLD + CYAN;
    public static final String BOLD_GREEN = BOLD + GREEN;
    public static final String BOLD_RED = BOLD + RED;
    
    public static final String BG_BLACK = "\u001B[40m";
    public static final String BG_RED = "\u001B[41m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_PURPLE = "\u001B[45m";
    public static final String BG_CYAN = "\u001B[46m";
    public static final String BG_WHITE = "\u001B[47m";
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public static void printHeader() {
        clearScreen();
        System.out.println(BOLD_CYAN + "  ============================================================" + RESET);
        System.out.println(BOLD_CYAN + "  >>   " + RESET + BOLD + "SECURITY UTILS v2.0" + RESET + BOLD_CYAN + "   [ENCRYPTION TOOLKIT]" + RESET);
        System.out.println(BOLD_CYAN + "  ============================================================" + RESET);
        System.out.println(CYAN + "  [*] Java 21 LTS | AES-256-CBC | SHA-256/512 | PBKDF2" + RESET);
        System.out.println();
    }
    
    public static void printMenu() {
        System.out.println(BOLD_CYAN + "  [+] MAIN MENU [OPERATIONS AVAILABLE]" + RESET);
        System.out.println(BOLD_CYAN + "  |-" + RESET);
        System.out.println(BOLD_CYAN + "  | " + RESET + GREEN + "[1]" + RESET + " Check password strength");
        System.out.println(BOLD_CYAN + "  | " + RESET + GREEN + "[2]" + RESET + " Generate secure password");
        System.out.println(BOLD_CYAN + "  | " + RESET + GREEN + "[3]" + RESET + " Generate memorable password");
        System.out.println(BOLD_CYAN + "  | " + RESET + GREEN + "[4]" + RESET + " Generate hash (MD5/SHA-256/SHA-512)");
        System.out.println(BOLD_CYAN + "  | " + RESET + GREEN + "[5]" + RESET + " AES-256 encryption");
        System.out.println(BOLD_CYAN + "  | " + RESET + GREEN + "[6]" + RESET + " AES-256 decryption");
        System.out.println(BOLD_CYAN + "  | " + RESET + GREEN + "[7]" + RESET + " Compare hashes");
        System.out.println(BOLD_CYAN + "  | " + RESET + RED + "[0]" + RESET + " Exit");
        System.out.println(BOLD_CYAN + "  |" + RESET);
        System.out.print(YELLOW + "  >>> " + RESET);
    }
    
    public static void printSuccess(String message) {
        System.out.println(GREEN + "  [+] " + RESET + BOLD_GREEN + message + RESET);
    }
    
    public static void printError(String message) {
        System.out.println(RED + "  [-] " + RESET + BOLD_RED + message + RESET);
    }
    
    public static void printWarning(String message) {
        System.out.println(YELLOW + "  [!] " + RESET + YELLOW + message + RESET);
    }
    
    public static void printInfo(String message) {
        System.out.println(CYAN + "  [*] " + RESET + CYAN + message + RESET);
    }

    public static void waitForEnter(java.util.Scanner scanner) {
        System.out.println(BOLD_CYAN + "\n  [>] Press ENTER to continue..." + RESET);
        try {
            scanner.nextLine();
        } catch (Exception e) {
            // Ignored
        }
    }
    
    public static void printSection(String title) {
        System.out.println();
        String line = "=".repeat(Math.min(60, 50 + title.length()));
        System.out.println(BOLD_CYAN + "  [>>] " + title + RESET);
        System.out.println(BOLD_CYAN + "  " + line + RESET);
    }
    
    public static void endSection() {
        System.out.println(BOLD_CYAN + "  " + "=".repeat(60) + RESET);
        System.out.println();
    }
    
    // Loading animation spinner
    public static void showLoadingAnimation(String message, int durationMillis) {
        String[] spinner = {"|", "/", "-", "\\"};
        long endTime = System.currentTimeMillis() + durationMillis;
        int index = 0;
        
        while (System.currentTimeMillis() < endTime) {
            System.out.print("\r" + BOLD_CYAN + "  [" + spinner[index % spinner.length] + "] " + RESET + message);
            System.out.flush();
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            
            index++;
        }
        
        System.out.println("\r" + BOLD_GREEN + "  [✓] " + RESET + BOLD_GREEN + message + RESET);
    }
    
    // Progress bar animation
    public static void showProgressBar(String message, int durationMillis) {
        long endTime = System.currentTimeMillis() + durationMillis;
        int steps = 20;
        
        for (int i = 0; i <= steps; i++) {
            int filled = (i * 100) / steps;
            int barLength = i;
            
            StringBuilder bar = new StringBuilder("[");
            for (int j = 0; j < steps; j++) {
                bar.append(j < barLength ? "=" : "-");
            }
            bar.append("]");
            
            System.out.print("\r" + BOLD_CYAN + "  " + bar + " " + filled + "% " + RESET + message);
            System.out.flush();
            
            long sleepTime = (endTime - System.currentTimeMillis()) / (steps - i);
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
        
        System.out.println();
    }
}
