package su.levenetc.playground.java.algs;

import java.util.Arrays;

public class WaveSort {
    public static int[] sort(int... nums){
        Arrays.sort(nums);
        int max = (nums.length % 2 == 0) ? nums.length : nums.length - 1;
        for (int i = 0; i < max; i += 2) {
            int n1 = nums[i];
            int n2 = nums[i + 1];
            nums[i] = n2;
            nums[i + 1] = n1;
        }
        return nums;
    }
}
