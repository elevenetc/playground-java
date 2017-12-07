package su.levenetc.playground.java.algs;

import java.util.HashSet;
import java.util.Set;

public class StringCombination {

    public static Set<String> get(String value) {
        HashSet<String> result = new HashSet<>();
        combinations(0, new StringBuilder(), value, result);
        return result;
    }

    private static void combinations(int start, StringBuilder output, String value, Set<String> result) {
        for (int i = start; i < value.length(); ++i) {
            output.append(value.charAt(i));
            result.add(output.toString());
            if (i < value.length()) {
                combinations(i + 1, output, value, result);
            }
            output.setLength(output.length() - 1);
        }
    }
}
