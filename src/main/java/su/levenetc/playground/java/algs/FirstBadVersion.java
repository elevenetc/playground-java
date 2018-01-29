package su.levenetc.playground.java.algs;

public class FirstBadVersion {

    static int max;
    static int from;

    static public int firstBadVersion(int max, int from, int n) {

        FirstBadVersion.max = max;
        FirstBadVersion.from = from;

        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static private int firstBadVersion(int left, int right) {
        if (left > right) return Integer.MAX_VALUE;
        if (left == right) return isBadVersion(left) ? left : Integer.MAX_VALUE;
        if (!isBadVersion(right)) return Integer.MAX_VALUE;

        int mid = (left + right) / 2;

        if (!isBadVersion(mid)) {
            return firstBadVersion(mid + 1, right);
        } else {
            return firstBadVersion(left, mid);
        }
    }

    static boolean isBadVersion(int v) {
        return v >= from;
    }
}
