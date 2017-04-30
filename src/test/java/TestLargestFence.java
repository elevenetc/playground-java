import org.junit.Test;
import su.levenetc.playground.java.algs.LargestFence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by eugene.levenetc on 30/04/2017.
 */
public class TestLargestFence {
    @Test
    public void testFit01() {
        assertTrue(LargestFence.isFit(new char[][]{
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'}
        }, 0, 0, 3, 3));
    }

    @Test
    public void testFit02() {
        assertTrue(LargestFence.isFit(new char[][]{
                new char[]{'.', '.', '.'},
                new char[]{'.', 'x', '.'},
                new char[]{'.', '.', '.'}
        }, 0, 0, 3, 3));
    }

    @Test
    public void testFit03() {
        assertFalse(LargestFence.isFit(new char[][]{
                new char[]{'.', '.', '.'},
                new char[]{'.', 'x', '.'},
                new char[]{'.', '.', 'x'}
        }, 0, 0, 3, 3));
    }

    @Test
    public void testFit04() {
        assertFalse(LargestFence.isFit(new char[][]{
                new char[]{'x', '.', '.'},
                new char[]{'.', 'x', '.'},
                new char[]{'.', '.', '.'}
        }, 2, 2, -3, -3));
    }

    @Test
    public void testFit05() {
        assertTrue(LargestFence.isFit(new char[][]{
                new char[]{'.', '.', '.'},
                new char[]{'.', 'x', '.'},
                new char[]{'.', '.', '.'}
        }, 2, 2, -3, -3));
    }

    @Test
    public void testFit06() {
        assertTrue(LargestFence.isFit(new char[][]{
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'}
        }, 1, 1, -2, -2));
    }
}
