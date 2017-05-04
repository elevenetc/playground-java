import org.junit.Test;
import su.levenetc.playground.java.algs.LargestFence;

import static org.junit.Assert.*;

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

    @Test
    public void testFence01() {
        assertEquals(6, LargestFence.get(new char[][]{
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', 'x'},
        }));
    }

    @Test
    public void testFence02() {

        assertEquals(8, LargestFence.get(new char[][]{
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'},
        }));
    }

    @Test
    public void testFence03() {

        assertEquals(0, LargestFence.get(new char[][]{
                new char[]{'x', '.', '.'},
                new char[]{'.', 'x', '.'},
                new char[]{'.', '.', 'x'},
        }));

    }

    @Test
    public void testFence04() {

        assertEquals(4, LargestFence.get(new char[][]{
                new char[]{'x', '.', '.'},
                new char[]{'x', '.', '.'},
                new char[]{'x', 'x', 'x'},
        }));

    }

    @Test
    public void testFence05() {

        assertEquals(6, LargestFence.get(new char[][]{
                new char[]{'x', '.', '.'},
                new char[]{'x', '.', '.'},
                new char[]{'x', '.', '.'},
                new char[]{'x', 'x', 'x'},
        }));

    }
}
