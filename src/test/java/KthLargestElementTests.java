import org.junit.Test;

import su.levenetc.playground.java.algs.KthLargestElement;

import static org.junit.Assert.assertEquals;

public class KthLargestElementTests {

    @Test
    public void test01() {
        assertEquals(3, KthLargestElement.get(1, 1, 2, 3));
    }

    @Test
    public void test02() {
        assertEquals(3, KthLargestElement.get(2, 1, 4, 2, 3));
    }

    @Test
    public void test03() {
        assertEquals(10, KthLargestElement.get(2, 1, 10));
    }

    @Test
    public void test04() {
        assertEquals(10, KthLargestElement.get(1, 10));
    }

}
