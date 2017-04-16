import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.RotateLetter.rotate;

/**
 * Created by eugene.levenetc on 16/04/2017.
 */
public class RotateLetterTest {
    @Test
    public void test01() {
        assertEquals('b', rotate('a', 1));
        assertEquals('a', rotate('z', 1));
        assertEquals('f', rotate('w', 87));
        assertEquals('j', rotate('a', 87));
    }
}