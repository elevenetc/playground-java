package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 02/04/2017.
 */
public class HammingDistance {

    public static int get(int valueA, int valueB) {
        int result = 0;
        int xor = valueA ^ valueB;
        boolean isFirstBit = false;
        while (xor != 0) {

            if (!isFirstBit) {
                isFirstBit = (xor & 0b1) == 0b1;
            }

            if (isFirstBit) {
                result++;
            }

            xor = xor >> 1;

        }

        return result - 1;
    }
}