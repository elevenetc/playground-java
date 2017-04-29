package su.levenetc.playground.java.utils;

import java.util.List;

/**
 * Created by eugene.levenetc on 16/02/2017.
 */
public class MathUtils {

    public static int[] ints(int... array){
        return array;
    }

    public static double getAngle(int x1, int y1, int x2, int y2) {
        double rads = Math.atan2(y1, x1) - Math.atan2(y2, x2);
        double result = Math.toDegrees(rads);
        if (result < 0) result += 360;
        String[] words;
        return result;
    }

    public static float distance(float diffX, float diffY) {
        return (float) Math.sqrt(diffX * diffX + diffY * diffY);
    }
}
