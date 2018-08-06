package su.levenetc.playground.java.algs;

public class MaxContiguousSum {
    public static int n(int... nums) {
        int result = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            result = Math.max(currentMax, result);
        }

        return result;
    }

    static int sqaure(int... nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int k = i; k < nums.length; k++) {
                result = Math.max(result, count(nums, i, k));
            }
        }
        return result;
    }

    static int count(int[] nums, int from, int to) {
        int result = 0;
        for (int i = from; i <= to; i++)
            result += nums[i];
        return result;
    }
}
