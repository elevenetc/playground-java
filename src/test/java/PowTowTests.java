import org.junit.Test;

import su.levenetc.playground.java.algs.PowTow;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 10/06/2017.
 */
public class PowTowTests {
    @Test
    public void run() {
        assertEquals(27, PowTow.get(0));
        assertEquals(27, PowTow.get(1));
        assertEquals(19683, PowTow.get(2));
    }
}
