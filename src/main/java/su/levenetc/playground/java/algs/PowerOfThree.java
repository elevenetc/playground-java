package su.levenetc.playground.java.algs;

/**
 * O(log3(n))
 */
public class PowerOfThree {
    static boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
