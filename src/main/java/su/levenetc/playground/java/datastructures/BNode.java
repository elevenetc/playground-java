package su.levenetc.playground.java.datastructures;

/**
 * Created by eugene.levenetc on 06/02/2017.
 */
public class BNode {

    public int value;
    public BNode left;
    public BNode right;
    public BNode parent;

    public BNode(int value) {
        this.value = value;
    }

    public void setLeftAndRight(int left, int right) {
        setLeft(new BNode(left));
        setRight(new BNode(right));
    }

    public BNode setLeft(int value) {
        return setLeft(new BNode(value));
    }

    public BNode setRight(int value) {
        return setRight(new BNode(value));
    }

    public BNode setLeft(BNode left) {
        this.left = left;
        this.left.parent = this;
        return left;
    }

    public BNode setRight(BNode right) {
        this.right = right;
        this.right.parent = this;
        return right;
    }

    @Override
    public String toString() {
        return String.format("{%d}", value);
    }
}
