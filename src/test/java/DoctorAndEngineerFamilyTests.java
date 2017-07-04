import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.DoctorAndEngineerFamily.get;

/**
 * Created by eugene.levenetc on 04/07/2017.
 */
public class DoctorAndEngineerFamilyTests {
    @Test
    public void test01() {
        assertEquals("Doctor", get(3));
    }

    @Test
    public void test02() {
        assertEquals("Engineer", get(1));
    }

    @Test
    public void test03() {
        assertEquals("Engineer", get(33554432));
    }
}
