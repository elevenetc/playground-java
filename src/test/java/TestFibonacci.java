import org.junit.Test;
import su.levenetc.playground.java.algs.Fibonacci;
import su.levenetc.playground.java.utils.Out;

import java.math.BigInteger;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 12/03/2017.
 */
public class TestFibonacci {

    private static final HashMap<Long, Long> numbers = new HashMap<Long, Long>() {{
        put(0L, 0L);
        put(1L, 1L);
        put(2L, 1L);
        put(3L, 2L);
        put(4L, 3L);
        put(5L, 5L);
        put(6L, 8L);
        put(7L, 13L);
        put(8L, 21L);
        put(9L, 34L);
        put(25L, 75025L);
    }};

    @Test
    public void testBigDecFormula() {
        for (long n : numbers.keySet()) {
            final long fibValue = numbers.get(n);
            assertEquals(fibValue, new Fibonacci.BigDecFormula((int) n).calc());
        }
    }

    @Test
    public void testFormula() {
        for (long n : numbers.keySet()) {
            final long fibValue = numbers.get(n);
            assertEquals(fibValue, new Fibonacci.Formula((int) n).calc());
        }
    }

    @Test
    public void testIterative() {
        for (long n : numbers.keySet()) {
            final long fibValue = numbers.get(n);
            assertEquals(fibValue, new Fibonacci.Iterative((int) n).calc());
        }
    }

    @Test
    public void testSpeed() {

        final int n = 200;
        final int times = 10000;
        final Fibonacci.Formula formula = new Fibonacci.Formula(n);
        final Fibonacci.Iterative iterative = new Fibonacci.Iterative(n);
        final Fibonacci.BigDecFormula bigDecFormula = new Fibonacci.BigDecFormula(n);

        Out.pln("Fib: " + n + ", times: " + times);
        Out.pln("Formula: " + checkFun(formula, times));
        Out.pln("FormulaBigDec: " + checkFun(bigDecFormula, times));
        Out.pln("Iterative: " + checkFun(iterative, times));
    }

    private BigInteger checkFun(Fibonacci.FibFun fun, int t) {
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
