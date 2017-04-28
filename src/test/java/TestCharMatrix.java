import org.junit.Test;
import su.levenetc.playground.java.datastructures.CharMatrix;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by eugene.levenetc on 29/04/2017.
 */
public class TestCharMatrix {
    @Test
    public void test01() {
        final String[] input = {
                "abc",
                "b--",
                "c--"
        };
        CharMatrix charMatrix = new CharMatrix();
        charMatrix.set(input);
        assertArrayEquals(input, charMatrix.toRows());
    }

    @Test
    public void test02() {
        final String[] input = {
                "---",
                "---",
                "---"
        };
        CharMatrix charMatrix = new CharMatrix();
        charMatrix.set(input);

        charMatrix.fill("xyz", 0, 1, true);
        charMatrix.fill("xzs", 2, 0, false);

        assertArrayEquals(new String[]{
                "--x",
                "xyz",
                "--s"
        }, charMatrix.toRows());
    }

}
