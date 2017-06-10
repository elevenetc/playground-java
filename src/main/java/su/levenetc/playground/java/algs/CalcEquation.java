package su.levenetc.playground.java.algs;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by eugene.levenetc on 10/06/2017.
 */
public class CalcEquation {
    public static int calc(int a, int b, int c, int d) {

        int result = 0;
        int x;
        int y;
        Map<Double, Integer> results = new TreeMap<>();

        for (int ic = 1; ic <= c; ic++) {
            x = ic;
            results.put(Math.pow(x, 2) - x * a, 1);
        }

        for (int id = 1; id <= d; id++) {

            y = id;
            double right = y * b - Math.pow(y, 2);

            if (results.containsKey(right)) {
                results.put(right, 2);
                result++;
            }

        }

        return result;
    }
}
