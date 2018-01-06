package su.levenetc.playground.java.algs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eugene.levenetc on 11/07/2017.
 */
public class ClimbingSteps {

    /**
     * O(n ^ 2)
     */
    public static int get(int steps) {
        if (steps <= 2) return steps;
        return getInternal(steps, new HashMap<>());
    }

    static int getInternal(int steps, Map<Integer, Integer> mem) {
        if (steps <= 0) return 0;
        if (steps <= 2) return steps;

        if (mem.containsKey(steps)) return mem.get(steps);

        int result = getInternal(steps - 1, mem) + getInternal(steps - 2, mem);
        mem.put(steps, result);
        return result;
    }

    /**
     * O(n)
     */
    public static int get2(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
