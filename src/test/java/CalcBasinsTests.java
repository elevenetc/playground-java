import org.junit.Test;
import su.levenetc.playground.java.algs.CalcBasins;
import su.levenetc.playground.java.utils.Utils;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by eugene.levenetc on 08/04/2017.
 */
public class CalcBasinsTests {
    @Test
    public void test() {
        int[] sizes = CalcBasins.calculateBasins(new int[][]{
                new int[]{1, 5, 2},
                new int[]{2, 4, 7},
                new int[]{3, 6, 9}
        });


        assertTrue(Utils.contains(sizes, 2));
        assertTrue(Utils.contains(sizes, 7));
        assertTrue(sizes.length == 2);


    }

    @Test
    public void test01() {
        int[] sizes = CalcBasins.calculateBasins(new int[][]{
                new int[]{1, 0, 2, 5, 8},
                new int[]{2, 3, 4, 7, 9},
                new int[]{3, 5, 7, 8, 9},
                new int[]{1, 2, 5, 4, 3},
                new int[]{3, 3, 5, 2, 1}
        });

        assertTrue(Arrays.equals(new int[]{11, 7, 7}, sizes));
    }
}
