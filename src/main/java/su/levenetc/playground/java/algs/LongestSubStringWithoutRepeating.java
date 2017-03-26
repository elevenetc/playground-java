package su.levenetc.playground.java.algs;

import java.util.List;

/**
 * Created by eugene.levenetc on 23/03/2017.
 */
public class LongestSubStringWithoutRepeating {

    public static String get(String s) {

        if (s == null) return null;
        if (s.length() <= 1) return s;

        StringBuilder longest = new StringBuilder();
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(i);
            final int charIndex = current.indexOf(String.valueOf(ch));
            if (charIndex >= 0) {

                if (longest.length() < current.length()) {
                    longest.setLength(0);
                    longest.append(current);
                }
                //current.reverse()
                //current.setLength(0);
            }
            current.append(ch);

        }

        final StringBuilder sb = longest.length() > current.length() ? longest : current;
        return sb.toString();
    }

    static String setToString(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }
        return sb.toString();
    }
}