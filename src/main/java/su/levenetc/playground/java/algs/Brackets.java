package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 09/02/2017.
 */
public class Brackets {
    public static boolean isValid(String brackets) {
        int result = 0;
        for (int i = 0; i < brackets.length(); i++) {
            final char c = brackets.charAt(i);
            if (c == '(') {
                result++;
            } else if (c == ')') {
                result--;
            }
            if (i < 0) {
                return false;
            }
        }
        return result == 0;
    }
}
