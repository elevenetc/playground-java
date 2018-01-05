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

    public static int get2(int s, int... nums) {
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= s) {
                result = Math.min(result, r - l + 1);
                sum -= nums[l++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
