import org.junit.Before;
import org.junit.Test;

import su.levenetc.playground.java.algs.MedianFromDataStream;

import static org.junit.Assert.assertEquals;

public class TestMedianFromDataStream {

    MedianFromDataStream structure;

    @Before
    public void before() {
        structure = new MedianFromDataStream();
    }

    @Test
    public void test01() {
        structure.add(1);
        structure.add(3);
        structure.add(2);
        assertEquals(2, structure.median(), 0);
    }

    @Test
    public void test02() {
        structure.add(1);
        structure.add(3);
        structure.add(2);
        structure.add(4);
        assertEquals(2.5, structure.median(), 0);
    }

    @Test
    public void test03() {
        structure.add(1);
        structure.add(2);
        assertEquals(1.5, structure.median(), 0);
    }
}
