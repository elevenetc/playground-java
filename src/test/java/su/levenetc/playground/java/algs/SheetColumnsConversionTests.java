package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.SheetColumnsConversion.stringToNum;

public class SheetColumnsConversionTests {
    @Test
    public void test() {
        assertEquals(731, stringToNum("ABC"));
        assertEquals(28, stringToNum("AB"));
        assertEquals(1, stringToNum("A"));
    }
}
