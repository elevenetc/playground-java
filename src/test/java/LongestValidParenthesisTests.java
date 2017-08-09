import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.LongestValidParenthesis.get;

public class LongestValidParenthesisTests {
    @Test
    public void test01() {
        assertEquals(4, get("(())"));
    }

    @Test
    public void test02() {
        assertEquals(2, get("(()("));
    }

    @Test
    public void test03() {
        assertEquals(10, get("()()((()))"));
    }

    @Test
    public void test04() {
        assertEquals(2, get("()"));
    }

    @Test
    public void test05() {
        assertEquals(2, get("))()"));
    }
}
