package su.levenetc.playground.java.algs;

public class MaximumSizeOfSubArrayEqualsK {


    /**
     * Square time
     */
    public static int get(int k, int... nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, sum(k, i, 0, nums));
            if (result == nums.length) break;
        }
        return result;
    }

    static int sum(int sum, int i, int len, int[] nums) {
        if (sum == 0) {

            if (i > nums.length - 1) {
                return len;
            } else {
                int n = nums[i];
                return Math.max(len, sum(sum - n, ++i, ++len, nums));
            }

        } else if (i > nums.length - 1) {
            return -1;
        } else {
            int n = nums[i];
            return sum(sum - n, ++i, ++len, nums);
        }
    }
}
