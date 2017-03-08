import org.junit.Test;
import su.levenetc.playground.java.utils.MathUtils;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 16/02/2017.
 */
public class MathTests {

    @Test
    public void angle() {
        assertEquals(90, MathUtils.getAngle(1, 0, 0, -1), 0);
        assertEquals(135, MathUtils.getAngle(1, 0, -1, -1), 0);
    }

}