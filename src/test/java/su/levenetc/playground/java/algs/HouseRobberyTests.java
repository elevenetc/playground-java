package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.dp.HouseRobbery.rob1;
import static su.levenetc.playground.java.algs.dp.HouseRobbery.rob2;
import static su.levenetc.playground.java.algs.dp.HouseRobbery.rob3;
import static su.levenetc.playground.java.utils.Utils.array;

public class HouseRobberyTests {
    @Test
    public void testLarge() {
        int[] houses = new int[]{104, 209, 137, 52, 158, 67, 213, 86, 141, 110, 151, 127, 238, 147, 169, 138, 240, 185, 246, 225, 147, 203, 83, 83, 131, 227, 54, 78, 165, 180, 214, 151, 111, 161, 233, 147, 124, 143};
        assertEquals(3176, rob1(houses));
        assertEquals(3176, rob2(houses));
        assertEquals(3176, rob3(houses));
    }

    @Test
    public void test(){
        int[] houses = array(1, 2, 1, 3, 6);
        assertEquals(8, rob1(houses));
        assertEquals(8, rob2(houses));
        assertEquals(8, rob3(houses));
    }
}
