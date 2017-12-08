package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.StringToInt.intToString;
import static su.levenetc.playground.java.algs.StringToInt.stringToInt;

public class StringToIntTests {
    @Test
    public void testStringToInt() {
        assertEquals(123, stringToInt("123"));
        assertEquals(99, stringToInt("99"));
    }

    @Test
    public void testIntToString() {
        assertEquals("123", intToString(123));
        assertEquals("99", intToString(99));
        assertEquals("0", intToString(0));
    }

}
