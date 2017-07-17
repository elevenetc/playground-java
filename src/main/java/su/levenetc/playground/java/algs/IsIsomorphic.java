package su.levenetc.playground.java.algs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eugene.levenetc on 18/07/2017.
 */
public class IsIsomorphic {
    public static boolean is(String valueA, String valueB) {
        if (valueA.length() != valueB.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        final char[] charsA = valueA.toCharArray();
        final char[] charsB = valueB.toCharArray();
        for (int i = 0; i < charsA.length; i++) {
            char chA = charsA[i];
            char chB = charsB[i];

            if (map.containsKey(chA)) {
                char chBValue = map.get(chA);
                if (chB != chBValue) {
                    return false;
                }
            } else {
                map.put(chA, chB);
            }
        }
        return true;
    }
}
