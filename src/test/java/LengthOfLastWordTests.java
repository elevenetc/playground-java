import org.junit.Test;

import su.levenetc.playground.java.algs.LengthOfLastWord;

import static org.junit.Assert.assertEquals;

public class LengthOfLastWordTests {
    @Test
    public void test01() {
        assertEquals(5, LengthOfLastWord.get("hello world"));
    }

    @Test
    public void test02() {
        assertEquals(5, LengthOfLastWord.get("hello"));
    }

    @Test
    public void test03() {
        assertEquals(5, LengthOfLastWord.get("hello world  "));
    }

    @Test
    public void test04() {
        assertEquals(0, LengthOfLastWord.get(""));
    }
}
