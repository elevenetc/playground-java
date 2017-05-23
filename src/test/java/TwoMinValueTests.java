import org.junit.Test;
import su.levenetc.playground.java.TwoMinValues;

import static utils.Asserts.assertEqualSets;

/**
 * Created by eugene.levenetc on 23/05/2017.
 */
public class TwoMinValueTests {
    @Test
    public void test01() {
        assertEqualSets(new int[]{0, 1}, TwoMinValues.get(0, 1, 2));
    }

    @Test
    public void test02() {
        assertEqualSets(new int[]{-1, 0}, TwoMinValues.get(0, -1, 1, 2, 1));
    }

    @Test
    public void test03() {
        assertEqualSets(new int[]{0, 0}, TwoMinValues.get(0, 0, 0));
    }

    @Test
    public void test04() {
        assertEqualSets(new int[]{-100, -5000}, TwoMinValues.get(-100, 0, -5000));
    }
}
