package su.levenetc.playground.java.algs;

import org.junit.Test;

import static su.levenetc.playground.java.algs.RotateString.rotate;
import static su.levenetc.playground.java.utils.TestUtils.assertEquals;

public class RotateStringTests {
    @Test
    public void test() {
        assertEquals("cdeab", rotate("abcde", 3));
    }
}
