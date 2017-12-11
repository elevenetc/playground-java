package su.levenetc.playground.java.algs;

public class ShiftZerosBack {
    public static int[] shift(int... nums) {
        int shiftBack = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value == 0) {
                shiftBack++;
            } else {
                nums[i - shiftBack] = value;
                if (shiftBack > 0)
                    nums[i] = 0;
            }
        }
        return nums;
    }
}
