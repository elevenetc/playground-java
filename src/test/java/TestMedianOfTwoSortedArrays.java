import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.MedianOfTwoSortedArrays.get;
import static su.levenetc.playground.java.utils.Utils.array;

public class TestMedianOfTwoSortedArrays {
    @Test
    public void test01() {
        assertEquals(2.5f, get(array(1, 2), array(3, 4)), 0);
    }

    @Test
    public void test02() {
        //assertEquals(4.5f, get(array(1, 4, 6), array(2, 5, 7)), 0);
    }
}
