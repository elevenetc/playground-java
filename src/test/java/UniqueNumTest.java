import org.junit.Test;
import su.levenetc.playground.java.algs.UniqueNum;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 25/05/2017.
 */
public class UniqueNumTest {
    @Test
    public void test01() {
        assertEquals(0, UniqueNum.get(1, 0, 1));
    }

    @Test
    public void test02() {
        assertEquals(13, UniqueNum.get(5, 1, 5, 1, 13));
    }
}
