package su.levenetc.playground.java.algs;

import java.util.Map;
import java.util.TreeMap;

import su.levenetc.playground.java.utils.Out;

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
            results.put(Math.pow(x, 2) - x * a, ic);
        }

        for (int id = 1; id <= d; id++) {

            y = id;

            if (results.containsKey(y * b - Math.pow(y, 2))) {
                //results.put(right, 2);
                result++;
            }

        }

        return result;
    }

    public static int calc2(int a, int b, int c, int d) {

        int result = 0;
        int x;
        int y;

        for (int ic = 1; ic <= c; ic++) {

            x = ic;
            int xa = x * a;

            for (int id = 1; id <= d; id++) {

                y = id;

                double left = Math.pow(x, 2) + Math.pow(y, 2);
                double right = xa + y * b;

                if (left == right) {
                    Out.pln(String.format("x:%d y:%d=%f", x, y, left));
                    result++;
                }
            }
        }

        return result;
    }
}
