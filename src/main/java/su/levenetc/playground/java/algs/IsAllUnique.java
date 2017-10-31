package su.levenetc.playground.java.algs;

import java.util.HashSet;
import java.util.Set;

public class IsAllUnique {
    public static boolean getAny(String value) {
        Set<Character> unique = new HashSet<>();
        char[] chars = value.toCharArray();

        for (char ch : chars) {
            if (unique.contains(ch)) {
                return false;
            }
            unique.add(ch);
        }
        return true;
    }

    public static boolean getPrintable(String value) {
        boolean[] unique = new boolean[94];
        int length = value.length();

        for (int i = 0; i < length; i++) {
            char ch = value.charAt(i);

            if (ch < 32 || ch > 126) throw new IllegalArgumentException("invalid char");

            int decValue = ch - 32;

            if (unique[decValue]) {
                return false;
            } else {
                unique[decValue] = true;
            }
        }
        return true;
    }
}
