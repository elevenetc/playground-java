package su.levenetc.playground.java.algs.dp;

import java.util.HashMap;
import java.util.Map;

public class HouseRobbery {

    public static int rob0(int... nums) {
        return rob0Int(0, nums);
    }

    private static int rob0Int(int i, int[] nums) {
        if (i > nums.length - 1) return 0;
        int r0 = rob0Int(i + 1, nums);
        int r1 = nums[i] + rob0Int(i + 2, nums);
        return Math.max(r0, r1);
    }

    //

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

    public static int rob2Invalid(int... nums) {
        if (nums == null || nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] m = new int[nums.length];
        m[0] = nums[0];
        m[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            int h1 = m[i - 2];
            int h2 = m[i - 1];
            int h3 = nums[i];
            m[i] = Math.max(h2, h1 + h3);
        }

        return m[nums.length - 1];
    }

    //

    public static int rob3Invalid(int... nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int h1 = nums[0];
        int h2 = nums[1];

        for (int i = 2; i < nums.length; i++) {
            int h3 = nums[i];
            int _h2 = h2;
            h2 = Math.max(h1 + h3, _h2);
            h1 = _h2;
        }

        return h2;
    }

    //

    public static int rob4(int... h) {
        int h1 = 0;
        int h2 = 0;
        for (int i = 0; i < h.length; i++) {
            int h3 = h[i];
            int _h2 = h2;
            h2 = Math.max(h1 + h3, h2);
            h1 = _h2;
            //
        }
        return h2;
    }

}
