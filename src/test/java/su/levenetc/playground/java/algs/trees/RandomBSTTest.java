package su.levenetc.playground.java.algs.trees;

import org.junit.Before;
import org.junit.Test;
import su.levenetc.playground.java.utils.DistributionTester;

public class RandomBSTTest {

    int[] values = new int[]{50, 25, 75, 10, 30};
    private RandomBST tree;

    @Before
    public void before() {
        tree = new RandomBST();
        for (int value : values) tree.insert(value);
    }

    @Test
    public void getRandomN() {
        new DistributionTester(100000, values.length, tree::getRandomN).assertMaxDistribution(0.1f);
    }

    @Test
    public void getRandomLogN() {
        new DistributionTester(100000, values.length, tree::getRandomLogN).assertMaxDistribution(0.1f);
    }
}