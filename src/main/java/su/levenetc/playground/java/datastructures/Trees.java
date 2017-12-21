package su.levenetc.playground.java.datastructures;

public class Trees {


    public static BNode simleLeftNonBST() {

        //     0
        //    /
        //   1

        BNode root = new BNode(0);
        root.left = new BNode(1);
        return root;
    }

    public static BNode simleRightNonBST() {

        //     0
        //      \
        //       1

        BNode root = new BNode(0);
        root.right = new BNode(1);
        return root;
    }


    public static BNode simpleTwoBST() {

        //     0
        //   /   \
        // -1     1

        BNode root = new BNode(0);
        root.left = new BNode(-1);
        root.right = new BNode(1);
        return root;
    }

    public static BNode perfectNonBST() {

        //        0
        //     /     \
        //    1       2
        //   / \     / \
        //  3   4   5   6

        BNode root = new BNode(0);
        root.setLeft(new BNode(1));
        root.setRight(new BNode(2));

        root.left.setLeft(new BNode(3));
        root.left.setRight(new BNode(4));

        root.right.setLeft(new BNode(5));
        root.right.setRight(new BNode(6));

        return root;
    }

    public static BNode perfectBalancedBST3() {

        //
        //       100
        //     /     \
        //    50     150
        //   /  \   /   \
        // 25   75 125  175
        //

        BNode root = new BNode(100);

        root.setLeft(new BNode(50));
        root.setRight(new BNode(150));

        root.left.setLeft(new BNode(25));
        root.left.setRight(new BNode(75));

        root.right.setLeft(new BNode(125));
        root.right.setRight(new BNode(175));

        return root;
    }

    public static BNode perfectBalancedBST3_2() {

        //
        //        5
        //     /     \
        //    3       7
        //  /   \   /   \
        // 1     4 6     8
        //

        BNode root = new BNode(5);

        root.setLeft(new BNode(3));
        root.setRight(new BNode(7));

        root.left.setLeft(new BNode(1));
        root.left.setRight(new BNode(4));

        root.right.setLeft(new BNode(6));
        root.right.setRight(new BNode(8));

        return root;
    }


    public static BNode bstZigZag() {

        //
        //     10
        //    /
        //   5
        //    \
        //     6
        //      \
        //       7
        //        \
        //         8
        //          \
        //           9
        //

        BNode root = new BNode(10);
        root.setLeft(5);
        root.left.setRight(6);
        root.left.right.setRight(7);
        root.left.right.right.setRight(8);
        root.left.right.right.right.setRight(9);

        return root;
    }

    public static BNode perfectBalancedBST4() {

        //
        //                 10
        //           /            \
        //          5              15
        //       /     \         /     \
        //      3       7       13     17
        //     / \     / \     /  \   /  \
        //    1   4   6   8   11  14 16  18
        //

        BNode root = new BNode(10);

        root.setLeft(new BNode(5));
        root.setRight(new BNode(15));

        root.left.setLeft(new BNode(3));
        root.left.setRight(new BNode(7));

        root.right.setLeft(new BNode(13));
        root.right.setRight(new BNode(17));

        root.left.left.setLeft(1);
        root.left.left.setRight(4);

        root.left.right.setLeft(6);
        root.left.right.setRight(8);

        root.right.left.setLeft(11);
        root.right.left.setRight(14);

        root.right.right.setLeft(16);
        root.right.right.setRight(18);

        return root;
    }

    public static BNode balancedBST4() {

        //                 10
        //           /            \
        //          5              15
        //       /     \         /     \
        //      3       7       13     17
        //     / \     / \            /  \
        //    1   4   6   8          16  18


        BNode root = perfectBalancedBST4();
        return new BTree(root).cutChildren(13);
    }


    public static BNode nonBST() {

        //          0
        //       /     \
        //     100     200
        //    /   \   /   \
        // 125   175 225  275

        BNode root = new BNode(0);

        root.setLeft(new BNode(100));
        root.setRight(new BNode(200));

        root.left.setLeft(new BNode(125));
        root.left.setRight(new BNode(175));

        root.right.setLeft(new BNode(225));
        root.right.setRight(new BNode(275));

        return root;
    }

    public static BNode unbalancedNonBST() {

        //          0
        //         /
        //        1
        //       /
        //      2
        //     /
        //    3
        //   /
        //  4
        // /
        //5

        BNode root = new BNode(0);
        root.setLeft(new BNode(1));
        root.left.setLeft(new BNode(2));
        root.left.left.setLeft(new BNode(3));
        root.left.left.left.setLeft(new BNode(4));
        root.left.left.left.left.setLeft(new BNode(5));
        return root;
    }

    public static BNode unbalancedNonBST2() {

        //          0
        //         / \
        //        1  100
        //       /     \
        //      2      200
        //     /         \
        //    3          300
        //   /
        //  4
        // /
        //5

        BNode root = unbalancedNonBST();
        root.setRight(new BNode(100));
        root.right.setRight(new BNode(200));
        root.right.right.setRight(new BNode(300));
        return root;
    }

    public static BNode unbalancedNonBST3() {

        //          0
        //         / \
        //        1  100
        //       /     \
        //      2      200
        //     /         \
        //    3          300
        //   / \
        //  4   10
        // /
        //5

        BNode root = unbalancedNonBST2();
        root.setRight(new BNode(100));
        root.right.setRight(new BNode(200));
        root.right.right.setRight(new BNode(300));
        new BTree(root).get(3).setRight(10);
        return root;
    }

}
