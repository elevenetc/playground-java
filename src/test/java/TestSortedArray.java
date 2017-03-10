import org.junit.Test;
import su.levenetc.playground.java.datastructures.SortedArray;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 10/03/2017.
 */
public class TestSortedArray {
    @Test
    public void testInsertion() {
        SortedArray so = new SortedArray(10);
        so.add(3);
        so.add(1);
        so.add(2);
        so.add(0);
        so.add(10);
        so.add(11);
        so.add(8);
        assertEquals(true, Arrays.equals(new int[]{0, 1, 2, 3, 8, 10, 11, 0, 0, 0}, so.getArray()));
    }
}
