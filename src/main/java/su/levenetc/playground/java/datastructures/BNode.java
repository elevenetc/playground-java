package su.levenetc.playground.java.datastructures;

/**
 * Created by eugene.levenetc on 06/02/2017.
 */
public class BNode {
    public int value;
    public BNode left;
    public BNode right;

    public BNode(int value) {
        this.value = value;
    }

    public void setLeft(BNode left) {
        this.left = left;
    }

    public void setRight(BNode right) {
        this.right = right;
    }
}
