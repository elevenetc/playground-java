package su.levenetc.playground.java.algs;

import java.util.HashMap;
import java.util.Map;

class IfPermutations {

    static boolean get0(String valueA, String valueB) {

        if (valueA.length() != valueB.length()) return false;

        StringBuilder sbB = new StringBuilder(valueB);

        int length = valueA.length();
        for (int i = 0; i < length; i++) {
            char chA = valueA.charAt(i);
            int indexB = sbB.indexOf(String.valueOf(chA));
            if (indexB == -1) {
                return false;
            } else {
                sbB.deleteCharAt(indexB);
            }
        }

        return true;
    }

    static boolean get1(String valueA, String valueB) {

        if (valueA.length() != valueB.length()) return false;

        Map<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < valueA.length(); i++) {
            char ch = valueA.charAt(i);
            if (counter.containsKey(ch)) {
                counter.put(ch, counter.get(ch) + 1);
            } else {
                counter.put(ch, 1);
            }
        }

        for (int i = 0; i < valueB.length(); i++) {
            char ch = valueB.charAt(i);
            if (counter.containsKey(ch)) {
                int count = counter.get(ch);

                if (count == 1) {
                    counter.remove(ch);
                } else {
                    counter.put(ch, count - 1);
                }
            } else {
                return false;
            }
        }

        return counter.isEmpty();
    }

}
