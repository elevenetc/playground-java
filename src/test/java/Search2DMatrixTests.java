import org.junit.Test;

import su.levenetc.playground.java.algs.Search2DMatrix;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Search2DMatrixTests {
    @Test
    public void test01() {
        assertTrue(Search2DMatrix.search(new int[][]{
                new int[]{1, 3, 5},
                new int[]{15, 20, 35},
                new int[]{40, 50, 60}
        }, 17));
    }

    @Test
    public void test02() {
        assertFalse(Search2DMatrix.search(new int[][]{
                new int[]{1, 3, 5},
                new int[]{15, 20, 35},
                new int[]{40, 50, 60}
        }, 80));
    }

    @Test
    public void test03() {
        assertTrue(Search2DMatrix.search(new int[][]{
                new int[]{1, 3, 5},
                new int[]{15, 20, 35},
                new int[]{40, 50, 60}
        }, 55));
    }

    @Test
    public void test06() {
        assertTrue(Search2DMatrix.search(new int[][]{
                new int[]{1, 3, 5, 6},
                new int[]{15, 20, 35, 36},
                new int[]{40, 50, 60, 61},
                new int[]{70, 80, 90, 91}
        }, 55));
    }

    @Test
    public void test07() {
        assertFalse(Search2DMatrix.search(new int[][]{
                new int[]{1, 3, 5, 6},
                new int[]{15, 20, 35, 36},
                new int[]{40, 50, 60, 61},
                new int[]{70, 80, 90, 91}
        }, 100));
    }


}
