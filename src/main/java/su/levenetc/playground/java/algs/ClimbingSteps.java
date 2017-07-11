package su.levenetc.playground.java.algs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eugene.levenetc on 11/07/2017.
 */
public class ClimbingSteps {
    public static int get(int steps) {
        if (steps <= 2) return steps;
        return getInternal(steps, new HashMap<>());
    }

    static int getInternal(int steps, Map<Integer, Integer> mem) {
        if (steps <= 0) return 0;
        if (steps <= 2) return steps;

        if (mem.containsKey(steps)) return mem.get(steps);

        final int result = getInternal(steps - 1, mem) + getInternal(steps - 2, mem);
        mem.put(steps, result);
        return result;
    }
}
