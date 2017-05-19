import org.junit.Test;
import su.levenetc.playground.java.algs.CircularWalk;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 18/05/2017.
 */
public class CircularWalkTests {
    @Test
    public void test0() {
        assertEquals(2, CircularWalk.find(9, 0, 2, 1, 3, 4, 7));
    }
}