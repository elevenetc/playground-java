package su.levenetc.playground.java.algs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sum3 {

    public static List<List<Integer>> sum3(int... nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            int a = nums[i];
            if (i == 0 || a > nums[i - 1]) {
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int b = nums[left];
                    int c = nums[right];

                    int sum = a + b + c;

                    if (sum == 0) result.add(Arrays.asList(a, b, c));

                    if (sum < 0) {
                        int currentLeft = left;
                        while (nums[currentLeft] == nums[left] && left < right) {
                            left++;
                        }
                    } else {
                        int currentRight = right;
                        while (nums[currentRight] == nums[right] && left < right) {
                            right--;
                        }
                    }

                }
            }
        }
        return result;
    }

}
