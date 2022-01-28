package org.example.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {

    public final static Pattern HAS_WRONG_SYMBOLS = Pattern.compile("\\D");

    private InputChecker() {
    }

    // чтобы избежать try-catch и использование исключений для "normal flow control"
    public static boolean checkInput(String input, int end) {
        if (input == null || input.length() == 0) {
            return false;
        }
        Matcher matcher = HAS_WRONG_SYMBOLS.matcher(input);
        if (matcher.find()) {
            return false;
        }
        int parsed = Integer.parseInt(input);
        return parsed > 0 && parsed <= end;
    }
}
