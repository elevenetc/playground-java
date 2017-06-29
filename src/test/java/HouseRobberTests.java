import org.junit.Test;

import su.levenetc.playground.java.algs.HouseRobber;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.utils.Utils.array;

/**
 * Created by eugene.levenetc on 23/06/2017.
 */
public class HouseRobberTests {
    @Test
    public void test01() {
        assertEquals(2, HouseRobber.get(array(1, 1, 1)));
    }

    @Test
    public void test02() {
        assertEquals(2, HouseRobber.get(array(1, 1, 1, 1)));
    }

    @Test
    public void test03() {
        assertEquals(1, HouseRobber.get(array(1, 1)));
    }

    @Test
    public void test04() {
        assertEquals(4, HouseRobber.get(array(1, 1, 3, 1)));
    }

    @Test
    public void test05() {
        assertEquals(6, HouseRobber.get(array(1, 1, 3, 1, 2)));
    }

    @Test
    public void test06() {
        assertEquals(3, HouseRobber.get(array(1, 2, 1, 1)));
    }

    @Test
    public void test07() {
        assertEquals(14, HouseRobber.get(array(4, 1, 2, 7, 5, 3, 1)));
    }

    @Test
    public void test08() {
        assertEquals(4, HouseRobber.get(array(1, 2, 3)));
    }
}
