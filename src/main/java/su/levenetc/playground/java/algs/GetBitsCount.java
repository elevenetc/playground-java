package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.utils.Out;

/**
 * Created by eugene.levenetc on 04/07/2017.
 */
public class GetBitsCount {
    public static int bitCount(int n) {
        int input = n;
        int count = 0;
        while (n > 0) {           // until all bits are zero
            if ((n & 1) == 1)     // check lower bit
                count++;
            n >>= 1;              // shift bits, removing lower bit
        }

        Out.pln(input, Out.toBin(input) + " > " + count);
        return count;
    }
}
