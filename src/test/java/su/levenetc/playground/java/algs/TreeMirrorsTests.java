package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.BNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.trees.TreeMirrors.isMirrored;
import static su.levenetc.playground.java.algs.trees.TreeMirrors.isMirroredIterative;
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
        testIsMirrored(true, mirrored());
        testIsMirrored(false, simpleTwoBST());
        testIsMirrored(false, perfectNonBST());
        testIsMirrored(false, almostMirrored());

        assertTrue(isMirroredTrees(mirrorOfPerfectNonBST(), perfectNonBST()));
        assertFalse(isMirroredTrees(mirrorOfPerfectNonBST(), balancedBST4()));
    }

    static void testIsMirrored(boolean expect, BNode root) {
        assertEquals(expect, isMirrored(root));
        assertEquals(expect, isMirroredIterative(root));
    }
}
