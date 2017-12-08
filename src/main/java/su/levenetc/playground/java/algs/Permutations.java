package su.levenetc.playground.java.algs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import su.levenetc.playground.java.utils.Out;

import static su.levenetc.playground.java.utils.StringUtils.multiply;
import static su.levenetc.playground.java.utils.StringUtils.setChar;
import static su.levenetc.playground.java.utils.StringUtils.swap;

/**
 * Created by eugene.levenetc on 23/04/2017.
 */
public class Permutations {

    public static Set<String> permutateIterative(String value) {
        Set<String> result = new HashSet<>();
        result.add(value);
        char[] a = value.toCharArray();
        int n = a.length;
        int[] weight = new int[n];  // Weight index control array initially all zeros. Of course, same size of the char array.
        int i = 1; //Upper bound index. i.e: if string is "abc" then index i could be at "c"
        while (i < n) {
            Out.pln(weight);
            if (weight[i] < i) { //if the weight index is bigger or the same it means that we have already switched between these i,j (one iteration before).
                int j = ((i % 2) == 0) ? 0 : weight[i];//Lower bound index. i.e: if string is "abc" then j index will always be 0.
                swap(a, i, j);
                result.add(join(a));
                weight[i]++; //Adding 1 to the specific weight that relates to the char array.
                i = 1; //if i was 2 (for example), after the swap we now need to swap for i=1
            } else {
                weight[i] = 0;//Weight index will be zero because one iteration before, it was 1 (for example) to indicate that char array a[i] swapped.
                i++;//i index will have the option to go forward in the char array for "longer swaps"
            }
        }
        return result;
    }

    private static String join(char[] a) {
        StringBuilder builder = new StringBuilder();
        builder.append(a);
        return builder.toString();
    }

    ///

    public static boolean arePerms(String permA, String permB) {

        if (permA.length() != permB.length()) return false;

        Set<Character> setA = new HashSet<>();

        for (int i = 0; i < permA.length(); i++) {
            setA.add(permA.charAt(i));
        }

        for (int i = 0; i < permB.length(); i++) {
            char chB = permB.charAt(i);
            if (setA.contains(chB)) {
                setA.remove(chB);
            } else {
                return false;
            }
        }
        return setA.isEmpty();
    }

    public static Set<String> permutateBin(int length) {
        permutateBin(multiply('0', length), 0);
        return null;
    }

    private static void permutateBin(String str, int currentBit) {
        int length = str.length();
        if (currentBit == length) {
            Out.plnIndex(str);
        } else {
            permutateBin(setChar(str, currentBit, '1'), currentBit + 1);
            permutateBin(setChar(str, currentBit, '0'), currentBit + 1);
        }
    }

    public static Set<String> permutateWithSwap(String string) {
        final String[] letters = string.split("");
        final Set<String> result = new HashSet<>();
        permutateWithSwap(letters, letters.length, result);
        return result;
    }

    private static void permutateWithSwap(String[] letters, int right, Set<String> result) {

        if (right == 1) {
            final String res = String.join("", letters);
            result.add(res);
        } else {

            final boolean alwaysLeft = right % 2 == 0;

            for (int left = 0; left < right; left++) {
                permutateWithSwap(letters, right - 1, result);
                swap(letters, alwaysLeft ? left : 0, right - 1);
            }
        }
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

    public static Set<String> permutateRecursive(String str) {
        Set<String> result = new HashSet<>();
        permute4Internal(str, 0, str.length() - 1, result);
        return result;
    }


    private static void permute4Internal(
            final String string,
            final int current,
            final int end,
            Set<String> result
    ) {
        if (current == end) {
            result.add(string);
        } else {
            for (int i = current; i <= end; i++) {
                permute4Internal(
                        swap(string, current, i),
                        current + 1,
                        end,
                        result
                );
            }
        }
    }

}
