import org.junit.Test;
import su.levenetc.playground.java.utils.Maps;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by eugene.levenetc on 15/09/16.
 */
public class TestMapUtils {
    @Test
    public void testFindMaxValue() {
        assertEquals(10, (int) Maps.findMaxValue(toMap(new int[]{10, 2, 3})));
        assertEquals(10, (int) Maps.findMaxValue(toMap(new int[]{2,10, 3})));
        assertEquals(10, (int) Maps.findMaxValue(toMap(new int[]{2, 3, 10})));
        assertEquals(10, (int) Maps.findMaxValue(toMap(new int[]{10})));
        assertEquals(0, (int) Maps.findMaxValue(toMap(new int[]{0})));
        assertEquals(2, (int) Maps.findMaxValue(toMap(new int[]{-1, 2})));
        assertNull(Maps.findMaxValue(toMap(new int[]{})));
    }

    private static HashMap<String, Integer> toMap(int[] array) {
        HashMap<String, Integer> result = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            result.put(i + "", array[i]);
        }
        return result;
    }
}