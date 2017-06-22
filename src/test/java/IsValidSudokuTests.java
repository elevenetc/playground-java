import org.junit.Test;

import su.levenetc.playground.java.algs.IsValidSudoku;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by eugene.levenetc on 22/06/2017.
 */
public class IsValidSudokuTests {
    @Test
    public void test01() {
        assertTrue(IsValidSudoku.get(new char[][]{
                new char[]{'.', '.', '.', '1', '4', '.', '.', '2', '.'},
                new char[]{'.', '.', '6', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '1', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '6', '7', '.', '.', '.', '.', '.', '9'},
                new char[]{'.', '.', '.', '.', '.', '.', '8', '1', '.'},
                new char[]{'.', '3', '.', '.', '.', '.', '.', '.', '6'},
                new char[]{'.', '.', '.', '.', '.', '7', '.', '.', '.'},
                new char[]{'.', '.', '.', '5', '.', '.', '.', '7', '.'}
        }));


    }

    @Test
    public void test02() {
        assertFalse(IsValidSudoku.get(new char[][]{
                new char[]{'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                new char[]{'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                new char[]{'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                new char[]{'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        }));
    }

    @Test
    public void test03() {
        assertFalse(IsValidSudoku.get(new char[][]{
                new char[]{'6', '.', '.', '1', '4', '.', '.', '2', '.'},
                new char[]{'.', '.', '6', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '1', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '6', '7', '.', '.', '.', '.', '.', '9'},
                new char[]{'.', '.', '.', '.', '.', '.', '8', '1', '.'},
                new char[]{'.', '3', '.', '.', '.', '.', '.', '.', '6'},
                new char[]{'.', '.', '.', '.', '.', '7', '.', '.', '.'},
                new char[]{'.', '.', '.', '5', '.', '.', '.', '7', '.'}
        }));


    }
}
