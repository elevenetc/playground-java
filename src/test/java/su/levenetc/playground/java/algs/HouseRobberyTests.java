package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.algs.dp.HouseRobbery;

import static org.junit.Assert.assertEquals;

public class HouseRobberyTests {
    @Test
    public void test() {
        int[] houses = new int[]{104, 209, 137, 52, 158, 67, 213, 86, 141, 110, 151, 127, 238, 147, 169, 138, 240, 185, 246, 225, 147, 203, 83, 83, 131, 227, 54, 78, 165, 180, 214, 151, 111, 161, 233, 147, 124, 143};
        assertEquals(3176, HouseRobbery.rob(houses));
        assertEquals(3176, HouseRobbery.robWithoutMemory(houses));
    }
}
