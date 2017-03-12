package su.levenetc.playground.java.algs;

import java.math.BigDecimal;

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

    public static class BigDecFormula implements FibFun {
        private int n;

        public BigDecFormula(int n) {
            this.n = n;
        }

        @Override
        public long calc() {
            if (n == 0) return 0;
            if (n == 1) return 1;
            if (n == 2) return 1;
            if (n == 3) return 2;
            if (n == 4) return 3;
            final BigDecimal two = BigDecimal.valueOf(2);
            final BigDecimal square = BigDecimal.valueOf(Math.sqrt(5));
            final BigDecimal pow1 = BigDecimal.ONE.add(square).divide(two, BigDecimal.ROUND_HALF_UP).pow(n);
            final BigDecimal pow2 = BigDecimal.ONE.min(square).divide(two, BigDecimal.ROUND_HALF_UP).pow(n);
            return pow1.add(pow2).divide(square, BigDecimal.ROUND_HALF_UP).longValue();
        }
    }

    public static class Formula implements FibFun {
        private int n;

        public Formula(int n) {
            this.n = n;
        }

        @Override
        public long calc() {
            if (n == 0) return 0;
            if (n == 1) return 1;
            if (n == 2) return 1;
            if (n == 3) return 2;
            if (n == 4) return 3;
            final double square = Math.sqrt(5);
            final double pow1 = Math.pow((1 + square) / 2, n);
            final double pow2 = Math.pow((1 - square) / 2, n);
            return Math.round((pow1 + pow2) / square);
        }
    }

    public interface FibFun {
        long calc();
    }
}
