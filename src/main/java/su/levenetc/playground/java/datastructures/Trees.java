package su.levenetc.playground.java.datastructures;

public class Trees {
    public static BNode perfectTree() {
        BNode root = new BNode(0);
        root.left = new BNode(1);
        root.right = new BNode(2);

        root.left.left = new BNode(3);
        root.left.right = new BNode(4);

        root.right.left = new BNode(5);
        root.right.right = new BNode(6);

        return root;
    }

    public static BNode perfectBST() {
        BNode root = new BNode(100);

        root.left = new BNode(50);
        root.right = new BNode(150);

        root.left.left = new BNode(25);
        root.left.right = new BNode(75);

        root.right.left = new BNode(125);
        root.right.right = new BNode(175);

        return root;
    }

    public static BNode minTree() {

        BNode root = new BNode(0);

        root.left = new BNode(100);
        root.right = new BNode(200);

        root.left.left = new BNode(125);
        root.left.right = new BNode(175);

        root.right.left = new BNode(225);
        root.right.right = new BNode(275);

        return root;
    }
}
