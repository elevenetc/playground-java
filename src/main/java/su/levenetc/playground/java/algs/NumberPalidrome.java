package su.levenetc.playground.java.algs;

import java.util.ArrayList;
import java.util.List;

public class NumberPalidrome {
    static boolean isPalindrome1(int num) {
        if (num < 0) return false;
        if (num < 10) return true;
        if (num % 10 == 0) return false;

        int half = 0;

        while (half < num) {
            half *= 10;
            half += num % 10;
            if (half == num) return true;
            num /= 10;
        }

        return num == half;
    }

    static boolean isPalindrome2(int num) {

        if (num == Integer.MIN_VALUE) return false;

        num = Math.abs(num);

        if (num < 10) return true;

        List<Integer> nums = new ArrayList<>();

        while (num != 0) {
            nums.add(num % 10);
            num /= 10;
        }

        int l = 0;
        int r = nums.size() - 1;
        while (l < r) {
            if ((int) nums.get(l) != nums.get(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
