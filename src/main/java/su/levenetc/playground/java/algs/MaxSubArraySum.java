package su.levenetc.playground.java.algs;

public class MaxSubArraySum {
    public static int get(int... nums) {

        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];

        int current = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            current = Math.max(n, n + current);
            max = Math.max(current, max);
        }

        return max;
    }
}
