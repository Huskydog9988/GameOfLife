public class Logger {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void error(String msg) {
        System.out.println(ANSI_RED + "[Error] " + ANSI_RESET + msg);
    }

    public static void warning(String msg) {
        System.out.println(ANSI_YELLOW + "[Warn] " + ANSI_RESET + msg);
    }

    public static void debug(String msg) {
        System.out.println(ANSI_CYAN + "[Debug] " + ANSI_RESET + msg);
    }

    public static void info(String msg) {
        System.out.println(ANSI_BLUE + "[Info] " + ANSI_RESET + msg);
    }
}
