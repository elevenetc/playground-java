import org.junit.Test;

import su.levenetc.playground.java.PolishNotation;

import static su.levenetc.playground.java.utils.TestUtils.assertEquals;

/**
 * Created by eugene.levenetc on 17/07/2017.
 */
public class TestPolishNotation {
    @Test
    public void test01() {
        assertEquals(9, PolishNotation.evaluateReverse("2", "1", "+", "3", "*"));
    }

    @Test
    public void test02() {
        assertEquals(6, PolishNotation.evaluateReverse("4", "13", "5", "/", "+"));
    }
}
