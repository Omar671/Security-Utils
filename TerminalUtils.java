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
        System.out.println(CYAN + "╔══════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "║" + PURPLE + "                  🔒 SECURITY UTILS v2.0                  " + CYAN + "     ║" + RESET);
        System.out.println(CYAN + "║" + YELLOW + "           Java Security Toolkit - Premium Edition        " + CYAN + "    ║" + RESET);
        System.out.println(CYAN + "╚══════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }
    
    public static void printMenu() {
        System.out.println(BLUE + "┌─── MAIN MENU ────────────────────────────────────────────────┐" + RESET);
        System.out.println(BLUE + "│" + RESET + "  " + GREEN + "1" + RESET + " │ Check password strength                         " + BLUE + "        │" + RESET);
        System.out.println(BLUE + "│" + RESET + "  " + GREEN + "2" + RESET + " │ Generate secure custom password                 " + BLUE + "        │" + RESET);
        System.out.println(BLUE + "│" + RESET + "  " + GREEN + "3" + RESET + " │ Generate memorable password                     " + BLUE + "        │" + RESET);
        System.out.println(BLUE + "│" + RESET + "  " + GREEN + "4" + RESET + " │ Generate hash (MD5/SHA-256/SHA-512)             " + BLUE + "        │" + RESET);
        System.out.println(BLUE + "│" + RESET + "  " + GREEN + "5" + RESET + " │ AES encryption with password                    " + BLUE + "        │" + RESET);
        System.out.println(BLUE + "│" + RESET + "  " + GREEN + "6" + RESET + " │ Compare hashes                                  " + BLUE + "        │" + RESET);
        System.out.println(BLUE + "│" + RESET + "  " + RED + "0" + RESET + " │ Exit                                              " + BLUE + "      │" + RESET);
        System.out.println(BLUE + "└──────────────────────────────────────────────────────────────┘" + RESET);
        System.out.print(YELLOW + "👉 Choose an option: " + RESET);
    }
    
    public static void printSuccess(String message) {
        System.out.println(GREEN + "✅ " + message + RESET);
    }
    
    public static void printError(String message) {
        System.out.println(RED + "❌ " + message + RESET);
    }
    
    public static void printWarning(String message) {
        System.out.println(YELLOW + "⚠️  " + message + RESET);
    }
    
    public static void printInfo(String message) {
        System.out.println(CYAN + "ℹ️  " + message + RESET);
    }
    
public static void waitForEnter() {
    System.out.println(YELLOW + "\n📥 Press Enter to continue..." + RESET);
    try {
        new java.util.Scanner(System.in).nextLine();
    } catch (Exception e) {
    }
}
    
    public static void printSection(String title) {
        System.out.println();
        System.out.println(PURPLE + "┌─ " + title + " " + "─".repeat(50 - title.length()) + "┐" + RESET);
    }
    
    public static void endSection() {
        System.out.println(PURPLE + "└" + "─".repeat(52) + "┘" + RESET);
        System.out.println();
    }
}
