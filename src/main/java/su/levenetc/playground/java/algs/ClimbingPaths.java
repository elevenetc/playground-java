package su.levenetc.playground.java.algs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eugene.levenetc on 23/06/2017.
 */
public class ClimbingPaths {
    public static int climbingStairs(int n) {
        return climbingStairsInternal(n, new HashMap<>());
    }

    public static int climbingStairsInternal(int n, Map<Integer, Integer> solutions) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        final int solutionKey = n - 1 + n - 2;
        if (solutions.containsKey(solutionKey)) {
            return solutions.get(solutionKey);
        }
        final int result = climbingStairsInternal(n - 1, solutions) + climbingStairsInternal(n - 2, solutions);
        solutions.put(solutionKey, result);
        return result;
    }
}
