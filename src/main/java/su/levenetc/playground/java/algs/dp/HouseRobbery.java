package su.levenetc.playground.java.algs.dp;

import java.util.HashMap;
import java.util.Map;

public class HouseRobbery {

    public static int robWithoutMemory(int... nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }

    public static int rob(int... nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return robInt(0, new HashMap<>(), nums);
    }

    static int robInt(int i, Map<Integer, Integer> mem, int... houses) {
        if (i > houses.length - 1) return 0;

        if (mem.containsKey(i)) return mem.get(i);

        int r0 = houses[i];
        int r1 = robInt(i + 1, mem, houses);
        int r2 = robInt(i + 2, mem, houses);

        int max = Math.max(r0 + r2, r1);
        mem.put(i, max);
        return max;
    }
}
