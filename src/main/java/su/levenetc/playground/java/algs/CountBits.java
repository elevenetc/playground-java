package su.levenetc.playground.java.algs;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/counting-bits/description/
 */
public class CountBits {

    public static int[] naive(int nums) {

        List<Integer> result = new LinkedList<>();
        result.add(0);

        for (int num = 1; num <= nums; num++) {
            int count = 0;
            int n = num;
            while (n != 0) {
                int bit = n & 1;
                n >>>= 1;
                count += bit;
            }
            result.add(count);
        }

        return toArray(result);
    }

    static int[] toArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
