public class AnsiCodes {

    public final static String ANSI_RESET = "\u001B[0m";
    public final static String ANSI_WHITE = "\u001B[37m";
    public final static String ANSI_RED = "\u001B[31m";
    public final static String ANSI_BLACK = "\u001B[30m";
    public final static String ANSI_RED_BACKGROUND = "\u001B[41m";
    public final static String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public final static String ANSI_CURSOR_RESET = "\033[H";
    public final static String ANSI_TERMINAL_RESET = "\033c";

    public static String create_ansi_character(String ansi_color_code, char character) {
        return ansi_color_code + character + ANSI_RESET;
    }

    public static String create_ansi_character(String ansi_background_code, String ansi_color_code, char character) {
        return ansi_background_code + ansi_color_code + character + ANSI_RESET;
    }

}
