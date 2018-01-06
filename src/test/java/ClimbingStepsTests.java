import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.ClimbingSteps.*;

/**
 * Created by eugene.levenetc on 11/07/2017.
 */
public class ClimbingStepsTests {
    @Test
    public void test01() {
        assertEquals(8, get(5));
        assertEquals(2, get(2));
        assertEquals(3, get(3));

        assertEquals(8, get2(5));
        assertEquals(2, get2(2));
        assertEquals(3, get2(3));
    }
}
