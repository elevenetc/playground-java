package su.levenetc.playground.java.algs;

public class LongestIncreasingSubsequence {
    public static int get(int... values) {
        if (values.length == 0) return 0;
        int[] dp = new int[values.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < dp.length; i++) {
            int iMax = 0;
            for (int j = 0; j < i; j++) {
                if (values[i] > values[j]) {
                    iMax = Math.max(iMax, dp[j]);
                }
            }
            dp[i] = iMax + 1;
        }

        for (int i : dp) {
            result = Math.max(result, i);
        }

        return result;
    }
}