package su.levenetc.playground.java.algs;

import java.util.Arrays;

public class SumClosest3 {

    public static int get(int target, int... nums) {

        int minDiff = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(nums);

        for (int a = 0; a < nums.length; a++) {

            int b = a + 1;
            int c = nums.length - 1;

            while (b < c) {

                int sum = nums[a] + nums[b] + nums[c];
                int diff = Math.abs(sum - target);

                if (sum == target) return sum;

                if (diff < minDiff) {
                    minDiff = diff;
                    result = sum;
                }

                if (sum > target) {
                    c--;
                } else {
                    b++;
                }
            }
        }


        return result;
    }


}