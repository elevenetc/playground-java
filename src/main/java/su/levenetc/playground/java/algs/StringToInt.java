package su.levenetc.playground.java.algs;

public class StringToInt {

    public static int stringToInt(String value) {
        int result = 0;
        int i = value.length() - 1;
        int dec = 1;
        while (i >= 0) {
            char ch = value.charAt(i);
            if (!isNumber(ch)) return -1;
            result += dec * numberOf(ch);
            dec *= 10;
            i--;
        }

        return result;
    }

    public static String intToString(int value) {

        if (value == 0) return "0";

        StringBuilder sb = new StringBuilder();
        while (value != 0) {
            int curr = value % 10;
            value = value / 10;
            sb.insert(0, curr);
        }
        return sb.toString();
    }

    private static char charOf(int i) {
        return (char) (48 + i);
    }

    private static int numberOf(char ch) {
        return ch - 48;
    }

    private static boolean isNumber(char ch) {
        return ch >= 48 && ch <= 57;
    }
}