package su.levenetc.playground.java.algs;

import java.util.Arrays;
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

    public static Set<String> permutate2(int length, char a, char b) {
        char[] chars = new char[length];
        Set<String> result = new HashSet<>();
        Arrays.fill(chars, a);
        permutate2Internal(chars, length, a, b, result);
        return result;
    }

    public static Set<String> permutate3(String str) {
        Set<String> result = new HashSet<>();
        permutate3Internal("", str, result);
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

    private static void permutate2Internal(char[] chars, int length, char a, char b, Set<String> result) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == a) {
                char[] copy = new char[length];
                System.arraycopy(chars, 0, copy, 0, chars.length);
                copy[i] = b;

                String str = new String(copy);
                if (result.contains(str)) continue;
                result.add(str);

                permutate2Internal(copy, length, a, b, result);
            }
        }
    }

    private static void permutate3Internal(String prefix, String str, Set<String> result) {
        int length = str.length();
        if (length == 0)
            result.add(prefix);
        else
            for (int i = 0; i < length; i++)
                permutate3Internal(
                        prefix + str.charAt(i),
                        str.substring(0, i) + str.substring(i + 1, length),
                        result
                );
    }

    private static void swap(String[] letters, int left, int right) {
        String temp = letters[left];
        letters[left] = letters[right];
        letters[right] = temp;
    }
}
