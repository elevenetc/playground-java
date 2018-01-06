package su.levenetc.playground.java.algs.dp;

import java.util.HashMap;
import java.util.Map;

public class HouseRobbery {

    public static int rob1(int... nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        else return robInt(0, new HashMap<>(), nums);
    }

    static int robInt(int i, Map<Integer, Integer> mem, int... houses) {
        if (i > houses.length - 1) return 0;
        else if (mem.containsKey(i)) return mem.get(i);

        int r1 = robInt(i + 1, mem, houses);
        int r2 = houses[i] + robInt(i + 2, mem, houses);

        int max = Math.max(r1, r2);
        mem.put(i, max);
        return max;
    }

    //

    public static int rob2(int... nums) {
        if (nums == null || nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];

        int[] m = new int[nums.length];
        m[0] = nums[0];
        m[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++)
            m[i] = Math.max(m[i - 1], m[i - 2] + nums[i]);

        return m[nums.length - 1];
    }

    //

    public static int rob3(int... nums) {
        int h0 = nums[0];
        int h1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int current = nums[i];
            int prev = h1;
            h1 = Math.max(h0 + current, h1);
            h0 = prev;
        }
        return h1;
    }

}
