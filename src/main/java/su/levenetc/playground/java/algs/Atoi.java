package su.levenetc.playground.java.algs;

public class Atoi {
    public static int parse(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (isNumberOrSign(str, i)) {
                return getNumber(str, i);
            } else if (ch == ' ') {
                continue;
            } else {
                break;
            }

        }
        return 0;
    }

    private static int getNumber(String str, int from) {

        int sign = str.charAt(from) == '-' ? -1 : 1;
        if (str.charAt(from) == '-' || str.charAt(from) == '+') from++;

        int result = 0;

        for (int i = from; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (isNumber(ch)) {

                int n = ch - '0';
                int newResult = result * 10 + n;

                if (isOverflowed(result, n)) {
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                } else {
                    result = newResult;
                }

            } else {
                return result * sign;
            }
        }

        return result * sign;
    }

    public static boolean isOverflowed(int result, int n) {
        long newValue = result * 10 + n;
        return (newValue - n) / 10 != result;
    }

    private static boolean isNumberOrSign(String str, int index) {

        char ch = str.charAt(index);

        if (ch == '-' || ch == '+') {
            if (index == str.length() - 1) return false;
            return isNumber(str.charAt(index + 1));
        } else {
            return isNumber(ch);
        }
    }

    private static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
