package su.levenetc.playground.java.algs;

import org.junit.Test;

import java.util.List;

import su.levenetc.playground.java.algs.trees.RandomBST;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomBSTTests {
    @Test
    public void test() {

        List<Integer> nodes = asList(5, 3, 7, 2, 4, 8, 10);
        RandomBST tree = new RandomBST();

        nodes.forEach(tree::insert);

        for (int i = 0; i < 100; i++)
            assertThat(nodes).contains(tree.getRandom());
    }
}
