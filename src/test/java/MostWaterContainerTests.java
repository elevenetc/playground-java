import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static su.levenetc.playground.java.algs.MostWaterContainer.get1;
import static su.levenetc.playground.java.algs.MostWaterContainer.get2;
import static su.levenetc.playground.java.utils.Utils.array;

public class MostWaterContainerTests {

    @Test
    public void test01() {
        assertArrayEquals(array(0, 2), get1(1, 1, 1));
        assertArrayEquals(array(0, 2), get2(1, 1, 1));
    }

    @Test
    public void test02() {
        assertArrayEquals(array(2, 3), get1(1, 1, 5, 10));
        assertArrayEquals(array(2, 3), get2(1, 1, 5, 10));
    }

    @Test
    public void test03() {
        assertArrayEquals(array(0, 2), get1(10, 1, 5, 1));
        assertArrayEquals(array(0, 2), get2(10, 1, 5, 1));
    }
}