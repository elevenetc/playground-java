import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.SumCombinations.combinations;
import static su.levenetc.playground.java.utils.Utils.list;

/**
 * Created by eugene.levenetc on 08/04/2017.
 */
public class TestSumCombinations {

    @Test
    public void test01() {
        Set<List<Integer>> combinations = combinations(9, 2, 3, 5, 9);

        assertTrue(combinations.contains(list(2, 2, 2, 3)));
        assertTrue(combinations.contains(list(2, 2, 5)));
        assertTrue(combinations.contains(list(3, 3, 3)));
        assertTrue(combinations.contains(list(9)));

        assertEquals(4, combinations.size());
    }

    @Test
    public void test02() {
        Set<List<Integer>> combinations = combinations(5, 3, 2, 1);

        assertTrue(combinations.contains(list(2, 3)));
        assertTrue(combinations.contains(list(1, 1, 1, 1, 1)));
        assertTrue(combinations.contains(list(2, 2, 1)));
        assertTrue(combinations.contains(list(1, 1, 3)));
        assertTrue(combinations.contains(list(1, 1, 1, 2)));

        assertEquals(5, combinations.size());
    }
}