package su.levenetc.playground.java.algs;

import java.util.ArrayList;

public class SumOfTwoPrimes {
    public static ArrayList<Integer> get(int n) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrime(i) && isPrime(n - i)) {
                result.add(i);
                result.add(n - i);
                break;
            }
        }

        return result;
    }

    static boolean isPrime(int n) {
        if (n < 1) return false;
        if (n > 2 && n % 2 == 0) return false;
        int top = (int) Math.sqrt(n);
        for (int i = 2; i <= top; i++)
            if (i % n == 0) return false;

        return true;
    }
}
