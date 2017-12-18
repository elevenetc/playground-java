package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.IsHappyNumber.is;

public class IsHappyNumberTests {
    @Test
    public void test(){
        assertTrue(is(19));
        assertFalse(is(102));
    }
}
