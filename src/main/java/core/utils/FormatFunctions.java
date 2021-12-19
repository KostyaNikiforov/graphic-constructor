package core.utils;

public class FormatFunctions {
    public static String formatNumber(String number) {
        if (!number.matches("\\d*")) {
            throw new RuntimeException("It is not a number: " + number);
        }
        int startP = number.length() % 3;
        StringBuilder result = new StringBuilder(number.substring(0, startP));
        for (int i = startP; i < number.length() - 2; i += 3) {
            result.append(" ").append(number, i, i + 3);
        }
        return result.toString().trim();
    }
}
