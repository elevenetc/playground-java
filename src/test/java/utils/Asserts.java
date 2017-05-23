package utils;

import java.util.Arrays;

/**
 * Created by eugene.levenetc on 23/05/2017.
 */
public class Asserts {
    public static void assertEqualSets(int[] a, int[] b) {
        if (a.length != b.length)
            throw new AssertionError("Different sizes:" + Arrays.toString(a) + " and " + Arrays.toString(b));

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                throw new AssertionError("Arrays are not the same at " + i + " with a:" + a[i] + " b:" + b[i]);
            }
        }
    }

    public static void assertContains(int value, int... array) {
        for (int i : array) {
            if (i == value) return;
        }
        throw new AssertionError("No value(" + value + ") in " + Arrays.toString(array));
    }
}
