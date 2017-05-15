package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 15/05/2017.
 */
public class FindMaxSumRange {
    public static int[] get(int[] a) {
        int left = 0;
        int right = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int maxLeftIndex = 0;
        int maxRightIndex = 0;
        for (int i = 0; i < a.length; i++) {
            final int leftValue = a[i];
            final int rightValue = a[a.length - i - 1];
            left += leftValue;
            right += rightValue;

            if (left > maxLeft) {
                maxLeft = left;
                maxLeftIndex = i;
            }

            if (right > maxRight) {
                maxRight = right;
                maxRightIndex = a.length - i - 1;
            }

            maxLeft = Math.max(left, maxLeft);
            maxRight = Math.max(right, maxRight);
        }
        return new int[]{maxRightIndex, maxLeftIndex};
    }
}
