package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.trees.IsBTBalanced.isBalanced;
import static su.levenetc.playground.java.datastructures.Trees.balancedBST4;
import static su.levenetc.playground.java.datastructures.Trees.perfectBalancedBST3;
import static su.levenetc.playground.java.datastructures.Trees.perfectBalancedBST4;
import static su.levenetc.playground.java.datastructures.Trees.perfectNonBST;
import static su.levenetc.playground.java.datastructures.Trees.simpleTwoBST;
import static su.levenetc.playground.java.datastructures.Trees.unbalancedNonBST;
import static su.levenetc.playground.java.datastructures.Trees.unbalancedNonBST2;
import static su.levenetc.playground.java.datastructures.Trees.unbalancedNonBST3;

public class IsBTBalancedTests {
    @Test
    public void test() {
        assertTrue(isBalanced(balancedBST4()));
        assertTrue(isBalanced(simpleTwoBST()));
        assertTrue(isBalanced(perfectNonBST()));
        assertTrue(isBalanced(perfectBalancedBST3()));
        assertTrue(isBalanced(perfectBalancedBST4()));
        assertFalse(isBalanced(unbalancedNonBST()));
        assertFalse(isBalanced(unbalancedNonBST2()));
        assertFalse(isBalanced(unbalancedNonBST3()));
    }
}