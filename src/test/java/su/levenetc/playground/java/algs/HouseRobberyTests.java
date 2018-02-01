package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.dp.HouseRobbery.rob0;
import static su.levenetc.playground.java.algs.dp.HouseRobbery.rob1;
import static su.levenetc.playground.java.algs.dp.HouseRobbery.rob2;
import static su.levenetc.playground.java.algs.dp.HouseRobbery.rob3;
import static su.levenetc.playground.java.utils.Utils.array;

public class HouseRobberyTests {
    @Test
    public void test() {
        rob(3176, array(104, 209, 137, 52, 158, 67, 213, 86, 141, 110, 151, 127, 238, 147, 169, 138, 240, 185, 246, 225, 147, 203, 83, 83, 131, 227, 54, 78, 165, 180, 214, 151, 111, 161, 233, 147, 124, 143));
        rob(8, array(1, 2, 1, 3, 6));
        rob(3, array(0, 3, 3, 0));
        rob(1, array(1, 1));
    }

    private void rob(int expected, int[] houses) {
        assertEquals(expected, rob0(houses));
        assertEquals(expected, rob1(houses));
        assertEquals(expected, rob2(houses));
        assertEquals(expected, rob3(houses));
    }
}
