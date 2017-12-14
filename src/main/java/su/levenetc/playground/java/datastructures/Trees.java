package su.levenetc.playground.java.datastructures;

public class Trees {

    public static BNode simpleTwoBST() {

        //     0
        //   /   \
        // -1     1

        BNode root = new BNode(0);
        root.left = new BNode(-1);
        root.right = new BNode(1);
        return root;
    }

    public static BNode perfectTree() {

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

    public static BNode perfectBalancedBST() {

        //       100
        //     /     \
        //    50     150
        //   /  \   /   \
        // 25   75 125  175

        BNode root = new BNode(100);

        root.setLeft(new BNode(50));
        root.setRight(new BNode(150));

        root.left.setLeft(new BNode(25));
        root.left.setRight(new BNode(75));

        root.right.setLeft(new BNode(125));
        root.right.setRight(new BNode(175));

        return root;
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

    public static BNode unbalanced() {

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

    public static BNode unbalanced2() {

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

        BNode root = unbalanced();
        root.setRight(new BNode(100));
        root.right.setRight(new BNode(200));
        root.right.right.setRight(new BNode(300));
        return root;
    }
}
