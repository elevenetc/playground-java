import org.junit.Test;
import su.levenetc.playground.java.algs.MaxElem;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.MaxElem.Action.*;

/**
 * Created by eugene.levenetc on 04/05/2017.
 */
public class TestMaxElem {
    @Test
    public void test1() {
        final List<Integer> result = MaxElem.get(
                add(0),
                add(1),
                add(3),
                print(),
                remove(),
                print()
        );
        assertEquals(Arrays.asList(3, 1), result);
    }
}
