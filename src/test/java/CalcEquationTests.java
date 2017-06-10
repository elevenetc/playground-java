import org.junit.Test;

import su.levenetc.playground.java.algs.CalcEquation;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 10/06/2017.
 */
public class CalcEquationTests {

    @Test
    public void test01() {
        assertEquals(1, (CalcEquation.calc2(1, 1, 1, 1)));
        assertEquals(3, (CalcEquation.calc2(10, 12, 50, 50)));
        assertEquals(3, (CalcEquation.calc2(10, 23, 50, 50)));
        assertEquals(2, (CalcEquation.calc2(51, 11, 50, 50)));
        assertEquals(0, (CalcEquation.calc2(51, 11, 19, 50)));
    }
}
