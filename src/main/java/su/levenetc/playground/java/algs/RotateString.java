package su.levenetc.playground.java.algs;

public class RotateString {
    static String rotate(String value, int shift) {
        shift = value.length() % shift;
        if (shift == 0) return value;
        int mid = value.length() - shift;
        String right = value.substring(mid, value.length() - 1);
        String left = value.substring(0, mid - 1);
        return right + left;
    }
}