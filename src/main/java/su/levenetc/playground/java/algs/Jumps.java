package su.levenetc.playground.java.algs;

public class Jumps {

    public static boolean jumpSquare(int... nums) {
        int[] mem = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            jumpSquare(mem, i + 1, nums[i]);
        }

        for (int i = 1; i < mem.length; i++) {
            if (mem[i] == 0) return false;
        }

        return true;
    }

    static void jumpSquare(int[] mem, int i, int count) {
        while (count != 0 && i < mem.length) {
            mem[i] += 1;
            i++;
            count--;
        }
    }

    public static boolean jumpExp(int... nums) {
        return jumpExp(nums, 0);
    }

    static boolean jumpExp(int[] jumps, int i) {
        if (i >= jumps.length - 1) {
            return true;
        } else {
            int count = jumps[i];
            if (count == 0) {
                return false;
            } else {
                for (int j = 1; j <= count; j++) {
                    boolean result = jumpExp(jumps, i + j);
                    if (result) return true;
                }
                return false;
            }
        }
    }
}
