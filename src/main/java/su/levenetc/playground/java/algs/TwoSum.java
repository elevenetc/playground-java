package su.levenetc.playground.java.algs;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {

    public static int[] get1(int[] nums, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = sum - nums[i];
            if (map.containsKey(complement))
                return new int[]{map.get(complement), i};

            map.put(nums[i], i);
        }
        return null;
    }

    public static int[] get2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int a = 0;
        int b = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            if (map.containsKey(complement)) {
                a = i;
                b = map.get(complement);
                break;
            } else {
                map.put(num, i);
            }
        }
        return new int[]{a, b};

    }

}
