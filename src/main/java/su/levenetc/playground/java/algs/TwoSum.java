package su.levenetc.playground.java.algs;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {
    public static int[] get(int[] nums, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = sum - nums[i];
            if (map.containsKey(complement))
                return new int[]{map.get(complement), i};

            map.put(nums[i], i);
        }
        return null;
    }
}
