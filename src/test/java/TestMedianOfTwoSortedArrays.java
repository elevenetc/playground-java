import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.MedianOfTwoSortedArrays.ver1;
import static su.levenetc.playground.java.algs.MedianOfTwoSortedArrays.ver2;
import static su.levenetc.playground.java.algs.MedianOfTwoSortedArrays.ver3;
import static su.levenetc.playground.java.algs.MedianOfTwoSortedArrays.ver4;
import static su.levenetc.playground.java.utils.Utils.array;

public class TestMedianOfTwoSortedArrays {

    @Test
    public void test01() {
        assertEquals(2.5f, ver1(array(1, 2), array(3, 4)), 0);
        assertEquals(2.5f, ver2(array(1, 2), array(3, 4)), 0);
        assertEquals(2.5f, ver3(array(1, 2), array(3, 4)), 0);
        assertEquals(2.5f, ver4(array(1, 2), array(3, 4)), 0);
    }

    @Test
    public void test02() {
        //1, 2, 4, 5, 6, 7
        assertEquals(4.5f, ver1(array(1, 4, 6), array(2, 5, 7)), 0);
        assertEquals(4.5f, ver2(array(1, 4, 6), array(2, 5, 7)), 0);
        assertEquals(4.5f, ver3(array(1, 4, 6), array(2, 5, 7)), 0);
        assertEquals(4.5f, ver4(array(1, 4, 6), array(2, 5, 7)), 0);
    }

    @Test
    public void test03() {
        //1, 2, 4, 5, 6, 9, 10
        assertEquals(5, ver1(array(1, 4, 6, 9, 10), array(2, 5)), 0);
        assertEquals(5, ver2(array(1, 4, 6, 9, 10), array(2, 5)), 0);
        assertEquals(5, ver3(array(1, 4, 6, 9, 10), array(2, 5)), 0);
        assertEquals(5, ver4(array(1, 4, 6, 9, 10), array(2, 5)), 0);
    }

    @Test
    public void test04() {
        assertEquals(3, ver1(array(1, 2), array(3, 4, 5)), 0);
        assertEquals(3, ver2(array(1, 2), array(3, 4, 5)), 0);
        assertEquals(3, ver3(array(1, 2), array(3, 4, 5)), 0);
        assertEquals(3, ver4(array(1, 2), array(3, 4, 5)), 0);
    }

    @Test
    public void test05() {
        assertEquals(51.5f, ver1(array(2, 3), array(100, 100)), 0);
        assertEquals(51.5f, ver2(array(2, 3), array(100, 100)), 0);
        assertEquals(51.5f, ver3(array(2, 3), array(100, 100)), 0);
        assertEquals(51.5f, ver4(array(2, 3), array(100, 100)), 0);
    }

    @Test
    public void test06() {
        assertEquals(6, ver1(array(1, 4, 6, 9, 10), array()), 0);
        assertEquals(6, ver2(array(1, 4, 6, 9, 10), array()), 0);
        assertEquals(6, ver3(array(1, 4, 6, 9, 10), array()), 0);
        assertEquals(6, ver4(array(1, 4, 6, 9, 10), array()), 0);
    }

    @Test
    public void test07() {
        assertEquals(7, ver1(array(1, 7), array(5, 10, 15)), 0);
        assertEquals(7, ver2(array(1, 7), array(5, 10, 15)), 0);
        assertEquals(7, ver3(array(1, 7), array(5, 10, 15)), 0);
        assertEquals(7, ver4(array(1, 7), array(5, 10, 15)), 0);
    }

    @Test
    public void test08() {
        assertEquals(2, ver1(array(1, 3), array(2)), 0);
        assertEquals(2, ver2(array(1, 3), array(2)), 0);
        assertEquals(2, ver3(array(1, 3), array(2)), 0);
        assertEquals(2, ver4(array(1, 3), array(2)), 0);
    }

    @Test
    public void test09() {
        //0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 65
        assertEquals(30, ver1(array(0, 10, 20, 30, 40, 50), array(5, 15, 25, 35, 45, 55, 65)), 0);
        assertEquals(30, ver2(array(0, 10, 20, 30, 40, 50), array(5, 15, 25, 35, 45, 55, 65)), 0);
        //assertEquals(30, ver3(array(0, 10, 20, 30, 40, 50), array(5, 15, 25, 35, 45, 55, 65)), 0);
        assertEquals(30, ver4(array(0, 10, 20, 30, 40, 50), array(5, 15, 25, 35, 45, 55, 65)), 0);
    }

    @Test
    public void test10() {
        //3 + 4 = 7
        assertEquals(3, ver4(array(0, 1, 2), array(3, 4, 5, 6)), 0);
    }
}
