package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 14/06/2017.
 */
public class LeastSumArrays {

    private static int aLow;
    private static int aHigh;
    private static int bLow;
    private static int bHigh;

    public static int get(int[] a, int[] b) {

        aLow = 0;
        aHigh = 0;
        bLow = 0;
        bHigh = 0;

        for (int i = 1; i < a.length; i++) {
            final int aValue = a[i];
            final int bValue = b[i];

            //set a

            if (aValue < a[aLow]) {
                aHigh = aLow;
                aLow = i;
            }

            if (a[aHigh] <= a[aLow]) {
                if (aValue > a[aLow]) aHigh = i;
            }

            //set b

            if (bValue < b[bLow]) {
                bHigh = bLow;
                bLow = i;
            }

            if (b[bHigh] <= b[bLow]) {
                if (bValue > b[bLow]) bHigh = i;
            }
        }

        if (aLow != bLow) {
            return a[aLow] + b[bLow];
        } else {
            if (aHigh == bHigh) {
                int sumA = a[aLow] + b[bHigh];
                int sumB = a[aHigh] + b[bLow];
                return Math.min(sumA, sumB);
            } else {
                int sumA1 = a[aLow] + b[bHigh];
                int sumA2 = a[aHigh] + b[bLow];
                int sumA3 = a[aHigh] + b[bHigh];

                int sumB1 = b[bLow] + a[aHigh];
                int sumB2 = b[bHigh] + a[aLow];
                int sumB3 = b[bHigh] + a[aHigh];

                return Math.min(Math.min(Math.min(sumA1, sumA2), sumA3), Math.min(Math.min(sumB1, sumB2), sumB3));
            }
        }
    }
}
