package su.levenetc.playground.java;

import java.util.Arrays;

/**
 * Created by elevenetc on 01/05/15.
 */
public class RotateArray {

    public static int[] withMem(int k, int... nums) {

        k = k % nums.length;
        if (k == 0) return nums;
        int mid = nums.length - k;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);

        System.arraycopy(right, 0, nums, 0, right.length);
        System.arraycopy(left, 0, nums, k, left.length);

        return nums;
    }

    public static int[] withoutMem(int k, int... nums) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        return nums;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
