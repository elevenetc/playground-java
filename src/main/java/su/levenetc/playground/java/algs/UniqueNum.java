package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 25/05/2017.
 */
public class UniqueNum {
    public static int get(int... values) {
        int val = 0;
        for (int num : values) {
            val = val ^ num;
        }
        return val;
    }
}
