package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.algs.PairFunctions.DiagonalCoder;
import su.levenetc.playground.java.algs.PairFunctions.ThirdValueCoder;

import static org.junit.Assert.assertArrayEquals;
import static su.levenetc.playground.java.utils.Utils.array;

public class PairFunctionsTests {
    @Test
    public void testThirdNumberCoder(){
        int a = 100;
        int b = 2342;
        ThirdValueCoder coder = new ThirdValueCoder(a + b);
        assertArrayEquals(array(a, b), coder.decode(coder.encode(a, b)));
    }

    @Test
    public void testDiagonalCoder(){
        int a = 234;
        int b = 4534;
        DiagonalCoder coder = new DiagonalCoder();
        assertArrayEquals(array(a, b), coder.decode(coder.encode(a, b)));
    }
}
