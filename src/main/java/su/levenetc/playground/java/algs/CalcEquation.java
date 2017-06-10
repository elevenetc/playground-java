package su.levenetc.playground.java.algs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eugene.levenetc on 10/06/2017.
 */
public class CalcEquation {

    public static int calc2(int a, int b, int c, int d) {

        int result = 0;
        int x;
        int y;
        Map<Double, Integer> results = new HashMap<>();

        for (int ic = 1; ic <= c; ic++) {

            x = ic;
            int xa = x * a;
            double powX = Math.pow(x, 2);
            double left = powX - xa;

            if (results.containsKey(left)) {
                results.put(left, results.get(left) + 1);
            } else {
                results.put(left, 1);
            }
        }

        for (int id = 1; id <= d; id++) {

            y = id;
            double right = y * b - Math.pow(y, 2);

            if (results.containsKey(right)) {
                result += results.get(right);
            }
        }


        return result;
    }
}
