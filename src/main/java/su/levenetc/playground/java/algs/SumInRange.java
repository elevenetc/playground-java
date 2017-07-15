package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 01/07/2017.
 */
public class SumInRange {

    static int[] aux;

    public static int get(int[] nums, int... query) {
        aux = new int[nums.length];
        aux[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            aux[i] = aux[i - 1] + nums[i - 1];
        }
        final int from = query[0];
        final int to = query[1];
        return aux[to] - aux[from - 1];
    }

}
