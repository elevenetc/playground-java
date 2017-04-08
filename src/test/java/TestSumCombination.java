import org.junit.Test;
import su.levenetc.playground.java.algs.SumCombination;
import su.levenetc.playground.java.utils.Utils;

import static org.junit.Assert.assertTrue;

/**
 * Created by eugene.levenetc on 08/04/2017.
 */
public class TestSumCombination {
    @Test
    public void test01() {
        final int[][] ints = Utils.toArrays(SumCombination.combinations(new int[]{2, 3, 5, 9}, 9));
        assertTrue(Utils.contains(ints, 2, 2, 2, 3));
        assertTrue(Utils.contains(ints, 2, 2, 5));
        assertTrue(Utils.contains(ints, 3, 3, 3));
        assertTrue(Utils.contains(ints, 9));
    }
}
