package su.levenetc.playground.java.algs;

import org.junit.Test;
import su.levenetc.playground.java.datastructures.BNode;
import su.levenetc.playground.java.datastructures.BTree;
import su.levenetc.playground.java.datastructures.Trees;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeEncoderTest {

    @Test
    public void test() {
        BinaryTreeEncoder encoder = new BinaryTreeEncoder();

//        testTree(encoder, Trees.almostBST());
        testTree(encoder, Trees.bstZigZag());
//        testTree(encoder, Trees.perfectBalancedBST4());
//        testTree(encoder, Trees.simpleTwoBST());
//        testTree(encoder, Trees.mirrorOfPerfectNonBST());
//        testTree(encoder, Trees.mirrored());
    }

    private void testTree(BinaryTreeEncoder encoder, BNode rootIn) {
        BNode rootOut = encoder.decode(encoder.encode(rootIn));
        BTree treeIn = new BTree(rootIn);
        BTree treeOut = new BTree(rootOut);
        assertThat(treeIn).isEqualTo(treeOut);
    }
}