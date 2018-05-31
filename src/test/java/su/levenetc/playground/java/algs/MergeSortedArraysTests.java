package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static su.levenetc.playground.java.algs.MergeSortedArrays.mergeInto;
import static su.levenetc.playground.java.algs.MergeSortedArrays.mergeNew;
import static su.levenetc.playground.java.utils.Utils.array;

public class MergeSortedArraysTests {
    @Test
    public void testMergeNew01() {
        assertArrayEquals(
                array(1, 2, 3, 4, 5, 6),
                mergeNew(
                        array(1, 3, 5),
                        array(2, 4, 6)
                )
        );
    }

    @Test
    public void testMergeNew02() {
        assertArrayEquals(
                array(-100, 0, 1, 2, 100, 155),
                mergeNew(
                        array(0, 1, 2),
                        array(-100, 100, 155)
                )
        );
    }

    @Test
    public void testMergeInto01() {
        assertThat(mergeInto(
                array(1, 2, 3, 0, 0, 0),
                3,
                array(4, 5, 6),
                3
        )).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void testMergeInto02() {
        assertThat(mergeInto(
                array(4, 5, 6, 0, 0, 0),
                3,
                array(1, 2, 3),
                3
        )).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void testMergeInto03() {
        assertThat(mergeInto(
                array(4, 4, 5, 0, 0, 0),
                3,
                array(1, 1, 3),
                3
        )).containsExactly(1, 1, 3, 4, 4, 5);
    }

    @Test
    public void testMergeInto04() {
        assertThat(mergeInto(
                array(1, 2, 4, 5, 6, 0),
                5,
                array(3),
                1
        )).containsExactly(1, 2, 3, 4, 5, 6);
    }

}