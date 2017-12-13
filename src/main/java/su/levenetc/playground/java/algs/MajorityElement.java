package su.levenetc.playground.java.algs;

public class MajorityElement {
    public static int get(int... nums) {

        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        int count = 1;
        int candidate = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
