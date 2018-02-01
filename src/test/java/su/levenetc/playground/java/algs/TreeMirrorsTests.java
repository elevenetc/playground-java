package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.trees.TreeMirrors.isMirrored;
import static su.levenetc.playground.java.algs.trees.TreeMirrors.isMirroredTrees;
import static su.levenetc.playground.java.datastructures.Trees.almostMirrored;
import static su.levenetc.playground.java.datastructures.Trees.balancedBST4;
import static su.levenetc.playground.java.datastructures.Trees.mirrorOfPerfectNonBST;
import static su.levenetc.playground.java.datastructures.Trees.mirrored;
import static su.levenetc.playground.java.datastructures.Trees.perfectNonBST;
import static su.levenetc.playground.java.datastructures.Trees.simpleTwoBST;

public class TreeMirrorsTests {
    @Test
    public void test() {
        assertTrue(isMirrored(mirrored()));
        assertFalse(isMirrored(simpleTwoBST()));
        assertFalse(isMirrored(perfectNonBST()));
        assertFalse(isMirrored(almostMirrored()));

        assertTrue(isMirroredTrees(mirrorOfPerfectNonBST(), perfectNonBST()));
        assertFalse(isMirroredTrees(mirrorOfPerfectNonBST(), balancedBST4()));
    }
}
