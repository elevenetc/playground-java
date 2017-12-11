package su.levenetc.playground.java.algs;

public class SumWithoutOperators {
    public static int sum(int x, int y){
        while (y != 0) {
            int carry = (x & y);
            x = x ^ y;
            y = carry << 1;
        }
        return x;
    }
}
