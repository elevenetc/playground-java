package su.levenetc.playground.java.algs;

public class MaxContiguousSum {
    static int n(int... nums) {
        int result = Integer.MIN_VALUE;
        int currentMax = 0;
        for (int num : nums) {
            currentMax += num;
            if (currentMax > result) {
                result = currentMax;
            } else if (currentMax < 0) {
                currentMax = 0;
            }
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
