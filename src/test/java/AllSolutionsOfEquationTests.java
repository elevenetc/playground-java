import org.junit.Test;

import java.util.List;

import static su.levenetc.playground.java.algs.AllSolutionsOfEquation.get;
import static utils.AssertUtils.assertContains;

public class AllSolutionsOfEquationTests {
    @Test
    public void test01() {
        List<int[]> result = get();
        assertContains(result, 4, 0, 2);
        assertContains(result, 9, 3, 0);
        assertContains(result, 5, 2, 1);
        assertContains(result, 1, 1, 0);
    }
}
