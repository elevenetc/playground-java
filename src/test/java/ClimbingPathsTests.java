import org.junit.Test;

import su.levenetc.playground.java.algs.ClimbingPaths;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 23/06/2017.
 */
public class ClimbingPathsTests {
    @Test
    public void test01() {
        assertEquals(5, ClimbingPaths.climbingStairs(4));
        assertEquals(46368, ClimbingPaths.climbingStairs(23));
        assertEquals(433494437, ClimbingPaths.climbingStairs(42));
    }
}
