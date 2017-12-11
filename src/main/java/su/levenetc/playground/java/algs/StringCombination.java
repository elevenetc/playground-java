package su.levenetc.playground.java.algs;

import java.util.HashSet;
import java.util.Set;

public class StringCombination {

    public static Set<String> get(String value) {
        HashSet<String> result = new HashSet<>();
        combinations(0, new StringBuilder(), value, result);
        return result;
    }

    private static void combinations(int start, StringBuilder combination, String value, Set<String> result) {
        for (int i = start; i < value.length(); ++i) {
            combination.append(value.charAt(i));
            result.add(combination.toString());
            combinations(i + 1, combination, value, result);
            combination.setLength(combination.length() - 1);
        }
    }
}
