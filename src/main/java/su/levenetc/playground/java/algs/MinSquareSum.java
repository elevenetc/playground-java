package su.levenetc.playground.java.algs;

import java.util.HashMap;
import java.util.Map;

public class MinSquareSum {
    public static int numSquares(int n) {
        int result = Integer.MAX_VALUE;
        int sqrt = 1;
        Map<String, Integer> mem = new HashMap<>();
        while (sqrt * sqrt < n) {
            result = Math.min(minSqrtSum(n, 0, 0, sqrt, mem), result);
            sqrt++;
        }
        return result;
    }

    static int minSqrtSum(int n, int sum, int counter, int sqrt, Map<String, Integer> mem) {

        if (mem.containsKey(sqrt + "-" + sum)) {
            return counter;
        }

        if (sum > n) {
            return Integer.MAX_VALUE;
        } else if (sum == n) {
            return counter;
        } else {
            int result = Integer.MAX_VALUE;

            while (sqrt * sqrt < n) {

                int calc;

                if (mem.containsKey(sqrt + "-" + sum)) {
                    calc = mem.get(sqrt + "-" + sum);
                } else {
                    calc = minSqrtSum(n, sqrt * sqrt + sum, counter + 1, sqrt, mem);
                    mem.put(sqrt + "-" + sum, calc);
                }

                result = Math.min(calc, result);
                sqrt++;
            }

            return result;
        }
    }
}
