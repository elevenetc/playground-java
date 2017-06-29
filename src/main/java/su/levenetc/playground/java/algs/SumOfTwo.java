package su.levenetc.playground.java.algs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by eugene.levenetc on 30/06/2017.
 */
public class SumOfTwo {
    public static boolean hasSum(int[] a, int[] b, int sum) {
        Set<Integer> diffs = new HashSet<>();
        for (int aValue : a) {
            diffs.add(sum - aValue);
        }

        for (int bValue : b) {
            if (diffs.contains(bValue)) return true;
        }

        return false;
    }
}
