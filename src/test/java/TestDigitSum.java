import org.junit.Test;
import su.levenetc.playground.java.algs.DigitSum;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 30/04/2017.
 */
public class TestDigitSum {
    @Test
    public void test02() {
        String n = "861568688536788";
        int i = 100000;
        assertEquals(3, DigitSum.run(n, i));
    }
}
