import org.junit.Test;
import su.levenetc.playground.java.algs.Fibonacci;
import su.levenetc.playground.java.utils.Out;

import java.math.BigInteger;

/**
 * Created by eugene.levenetc on 12/03/2017.
 */
public class TestFibonacci {
    @Test
    public void fib() {

        final int n = 10;
        final int times = 10000;
        final Fibonacci.Formula formula = new Fibonacci.Formula(n);
        final Fibonacci.Iterative iterative = new Fibonacci.Iterative(n);

        Out.pln("Formula: " + checkFun(formula, times));
        Out.pln("Iterative: " + checkFun(iterative, times));
    }

    private BigInteger checkFun(Fibonacci.FibFun fun, int t){
        long[] times = new long[t];
        BigInteger result = BigInteger.valueOf(0);

        for (int i = 0; i < times.length; i++) {
            times[i] = checkTime(fun);
        }

        for (int i = 0; i < times.length; i++) {
            result = result.add(BigInteger.valueOf(times[i]));
        }

        return result.divide(BigInteger.valueOf(times.length));
    }

    private long checkTime(Fibonacci.FibFun fun) {
        final long start = System.nanoTime();
        fun.calc();
        return System.nanoTime() - start;
    }
}
