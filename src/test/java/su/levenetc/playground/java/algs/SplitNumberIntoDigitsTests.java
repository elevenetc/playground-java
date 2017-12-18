package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.SplitNumberIntoDigits.split;
import static su.levenetc.playground.java.utils.Utils.list;

public class SplitNumberIntoDigitsTests {
    @Test
    public void test() {
        assertEquals(list(8, 6, 5, 8), split(8568));
    }
}
