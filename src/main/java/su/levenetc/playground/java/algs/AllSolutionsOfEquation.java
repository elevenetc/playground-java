package su.levenetc.playground.java.algs;

import java.util.LinkedList;
import java.util.List;

import su.levenetc.playground.java.utils.Out;

public class AllSolutionsOfEquation {
    public static List<int[]> get() {
        List<int[]> result = new LinkedList<>();
        //y = a ^ 2 + b ^ 2
        int l = 10;

        List<int[]> abPairs = new LinkedList<>();

        for (int a = 0; a < l; a++) {
            for (int b = 0; b < l; b++) {
                abPairs.add(new int[]{a, b});
            }
        }

        for (int[] abPair : abPairs) {
            int a = abPair[0];
            int b = abPair[1];

            for (int y = 0; y < l; y++) {
                if (y == a * a + b * b) {
                    result.add(new int[]{y, a, b});
                    Out.format("%d = %d ^ 2 + %d ^ 2", y, a, b);
                }
            }
        }

        return result;
    }
}
