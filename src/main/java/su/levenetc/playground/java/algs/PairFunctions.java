package su.levenetc.playground.java.algs;

public class PairFunctions {

    public static class DiagonalCoder implements PairCoder {

        @Override
        public int encode(int a, int b) {
            return ((a + b) * (a + b) + 3 * a + b) / 2;
        }

        @Override
        public int[] decode(int n) {
            int s = (int) Math.sqrt(2 * n);
            int a = (2 * n - s * s - s) / 2;
            int b = s - a;
            return new int[]{a, b};
        }
    }

    public static class ThirdValueCoder implements PairCoder {

        final int c;

        public ThirdValueCoder(int c) {
            this.c = c;
        }

        @Override
        public int encode(int a, int b) {
            //c must be >= a + b
            return a * c + b;
        }

        @Override
        public int[] decode(int n) {
            return new int[]{n / c, n % c};
        }
    }

    interface PairCoder {
        int encode(int a, int b);

        int[] decode(int n);
    }
}
