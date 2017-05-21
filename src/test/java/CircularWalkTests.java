import org.junit.Test;
import su.levenetc.playground.java.algs.CircularWalk;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 18/05/2017.
 */
public class CircularWalkTests {
    @Test
    public void test0() {
        assertEquals(2, CircularWalk.find(9, 0, 2, 1, 3, 4, 7, null));
    }

    @Test
    public void test1() {
        assertEquals(2, CircularWalk.find(0, 2, new int[]{
                1, 0, 4, 2, 3, 6, 1, 0, 4
        }));
    }

    @Test
    public void test2() {
        assertEquals(2, CircularWalk.find(0, 2, new int[]{
                1, 10, 1, 1, 1
        }));
    }

    @Test
    public void test3() {
        assertEquals(1, CircularWalk.find(0, 1, new int[]{
                10, 10, 1, 1, 1
        }));
    }

    @Test
    public void test4() {
        assertEquals(3, CircularWalk.find(0, 3, new int[]{
                1, 1, 1, 1, 1, 1
        }));
    }
}