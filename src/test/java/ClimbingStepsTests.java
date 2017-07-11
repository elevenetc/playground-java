import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.ClimbingSteps.get;

/**
 * Created by eugene.levenetc on 11/07/2017.
 */
public class ClimbingStepsTests {
    @Test
    public void test01() {
        assertEquals(8, get(5));
    }

    @Test
    public void test02() {
        assertEquals(2, get(2));
    }

    @Test
    public void test03() {
        assertEquals(3, get(3));
    }
}
