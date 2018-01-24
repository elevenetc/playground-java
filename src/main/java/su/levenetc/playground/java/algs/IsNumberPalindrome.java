package su.levenetc.playground.java.algs;

public class IsNumberPalindrome {
    static boolean isNumberPalindrome(int n) {
        int v = 0;
        while (n > v) {
            v *= 10;
            v += n % 10;
            if (v == n) return true;
            n /= 10;
        }

        return n == v;
    }
}
