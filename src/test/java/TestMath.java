import org.junit.Test;
import su.levenetc.playground.java.math.GreatestCommonDivisor;
import su.levenetc.playground.java.math.LeastCommonMultiple;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 18/03/2017.
 */
public class TestMath {
    @Test
    public void testGCD() {
        assertEquals(10, GreatestCommonDivisor.calc(20, 10));
        assertEquals(17657, GreatestCommonDivisor.calc(28851538, 1183019));
        assertEquals(17657, GreatestCommonDivisor.calc(1183019, 28851538));
    }
    @Test
    public void testLCM(){
        assertEquals(24, LeastCommonMultiple.calc(6, 8));
        assertEquals(1933053046, LeastCommonMultiple.calc(28851538, 1183019));
    }
}
