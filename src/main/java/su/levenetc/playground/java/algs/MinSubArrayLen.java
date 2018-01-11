package su.levenetc.playground.java.algs;

public class MinSubArrayLen {

    public static int get(int s, int... nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            result = Math.min(result, minSubArrayLen(s, i, 0, nums));
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    static int minSubArrayLen(int sum, int index, int len, int[] nums) {

        if (sum <= 0) {
            return len;
        } else if (index > nums.length - 1) {
            return Integer.MAX_VALUE;
        } else {
            int n = nums[index];
            return minSubArrayLen(sum - n, ++index, ++len, nums);
        }
    }

    ///

    public static int get2(int sum, int... nums) {
        int currentSum = 0;
        int result = Integer.MAX_VALUE;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];
            while (currentSum >= sum) {
                int currentLen = end - start + 1;
                result = Math.min(result, currentLen);
                currentSum -= nums[start];
                start++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
