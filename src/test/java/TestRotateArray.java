import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static su.levenetc.playground.java.RotateArray.withMem;
import static su.levenetc.playground.java.utils.Utils.array;

/**
 * Created by eugene.levenetc on 10/07/2017.
 */
public class TestRotateArray {
    @Test
    public void test01() {
        assertArrayEquals(array(1, 2, 0), withMem(2, 0, 1, 2));
    }

    @Test
    public void test02() {
        assertArrayEquals(array(5, 0, 1, 2, 3, 4), withMem(1, 0, 1, 2, 3, 4, 5));
    }

    @Test
    public void test03() {
        assertArrayEquals(array(0, 1, 2, 3, 4, 5), withMem(6, 0, 1, 2, 3, 4, 5));
    }

    @Test
    public void test04() {
        assertArrayEquals(array(2, 0, 1), withMem(4, 0, 1, 2));
    }
}
