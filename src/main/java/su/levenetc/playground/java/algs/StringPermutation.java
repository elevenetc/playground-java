package su.levenetc.playground.java.algs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by eugene.levenetc on 23/04/2017.
 */
public class StringPermutation {

    public static Set<String> permutate(String string) {
        final String[] letters = string.split("");
        final Set<String> result = new HashSet<>();
        permutateInternal(letters, letters.length, result);
        return result;
    }

    private static void permutateInternal(String[] letters, int right, Set<String> result) {

        if (right == 1) {
            final String res = String.join("", letters);
            result.add(res);
        } else {

            final boolean alwaysLeft = right % 2 == 0;

            for (int left = 0; left < right; left++) {
                permutateInternal(letters, right - 1, result);
                swap(letters, alwaysLeft ? left : 0, right - 1);
            }
        }

    }

    private static void swap(String[] letters, int left, int right) {
        String temp = letters[left];
        letters[left] = letters[right];
        letters[right] = temp;
    }
}
