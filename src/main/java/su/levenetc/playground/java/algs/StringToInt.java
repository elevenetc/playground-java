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

        if (value < 10) return charOf(value) + "";

        int dec = 10;
        int dev = 1;
        StringBuilder sb = new StringBuilder();

        while (value != 0) {
            int rem = value % dec;
            value -= rem;

            sb.insert(0, charOf(rem / dev));

            dec *= 10;
            dev *= 10;
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