package su.levenetc.playground.java.algs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class IsPermutationOfPalindrome {
    static boolean get(String value) {
        Map<Character, Integer> map = new HashMap<>();
        value = removeSpaces(value);
        for (int i = 0; i < value.length(); i++) {
            char ch = Character.toLowerCase(value.charAt(i));
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                map.put(ch, count + 1);
            } else {
                map.put(ch, 1);
            }
        }

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        boolean even = value.length() % 2 == 0;
        boolean middleFound = false;
        for (Map.Entry<Character, Integer> entry : entries) {
            int v = entry.getValue();

            if (v == 1) {
                if (even) return false;
                if (middleFound) return false;
                else middleFound = true;
            } else if (v % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    static String removeSpaces(String value) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (ch == ' ') continue;
            sb.append(ch);
        }
        return sb.toString();
    }
}
