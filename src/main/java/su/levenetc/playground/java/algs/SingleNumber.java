package su.levenetc.playground.java.algs;

public class SingleNumber {
    public static int get(int... nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
