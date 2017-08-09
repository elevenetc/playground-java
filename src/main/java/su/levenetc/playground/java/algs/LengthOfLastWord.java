package su.levenetc.playground.java.algs;

public class LengthOfLastWord {
    public static int get(String value) {

        if (value == null || value.length() == 0) return 0;

        char[] chars = value.toCharArray();
        int result = 0;
        boolean counting = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            char ch = chars[i];
            if (counting) {
                if (ch == ' ') {
                    return result;
                } else {
                    result++;
                }
            } else {
                if (ch != ' ') {
                    result++;
                    counting = true;
                }
            }
        }
        return result;
    }
}