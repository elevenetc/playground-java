import org.junit.Test;
import su.levenetc.playground.java.algs.PowerSum;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 24/04/2017.
 */
public class TestPowerSum {
    @Test
    public void test01(){
        assertEquals(3, PowerSum.powerSum(100, 2));
    }
}
