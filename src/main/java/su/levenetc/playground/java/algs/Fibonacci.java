package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 12/03/2017.
 */
public class Fibonacci {

    public static class Iterative implements FibFun {
        private int n;

        public Iterative(int n) {
            this.n = n;
        }

        @Override
        public long calc() {
            long[] numbers = new long[n + 1];
            for (int i = 0; i <= n; i++) {
                if (i <= 1) {
                    numbers[i] = i;
                } else {
                    numbers[i] = numbers[i - 1] + numbers[i - 2];
                }
            }
            return numbers[n];
        }
    }

    public static class Formula implements FibFun {
        private int n;

        public Formula(int n) {
            this.n = n;
        }

        @Override
        public long calc() {
            final double square = Math.sqrt(5);
            final double pow1 = Math.pow((1 + square) / 2, n);
            final double pow2 = Math.pow((1 - square) / 2, n);
            return (long) ((pow1 + pow2) / square);
        }
    }

    public interface FibFun {
        long calc();
    }
}
