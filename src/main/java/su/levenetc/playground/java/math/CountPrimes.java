package su.levenetc.playground.java.math;

public class CountPrimes {

    public static int countWithMem(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        return count;
    }

    public static int count(int n) {
        int counter = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                counter++;
            }
        }
        return counter;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n > 2 && n % 2 == 0) return false;

        for (int i = 3; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
