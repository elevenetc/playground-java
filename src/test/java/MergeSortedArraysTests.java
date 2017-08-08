import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static su.levenetc.playground.java.algs.MergeSortedArrays.merge;
import static su.levenetc.playground.java.utils.Utils.array;

public class MergeSortedArraysTests {
    @Test
    public void test01() {
        assertArrayEquals(
                array(1, 2, 3, 4, 5, 6),
                merge(
                        array(1, 3, 5),
                        array(2, 4, 6)
                )
        );
    }

    @Test
    public void test02() {
        assertArrayEquals(
                array(-100, 0, 1, 2, 100, 155),
                merge(
                        array(0, 1, 2),
                        array(-100, 100, 155)
                )
        );
    }

}
