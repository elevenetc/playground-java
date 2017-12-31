package su.levenetc.playground.java.algs;

/**
 Out.pln(maxSum(-2, 1, -3, 4, -1, 2, 1, -5, 4));
 Out.pln(maxSum(1, 2, 3, -100, 100));
 Out.pln(maxSum(1, 2, 3, -100, 1, -2, 10, -5, 1, 2, 3, 4, 5, 6, 7));
 Out.pln(maxSum(-2, 1));
 Out.pln(maxSum(-2, -2));
 */
public class MaxSubArraySum {
    public static int get(int... nums) {

        int max = nums[0];
        int current = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            current = Math.max(current + nums[i], nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }
}
