package su.levenetc.playground.java.datastructures;

/**
 * Created by eugene.levenetc on 06/02/2017.
 */
public class BTNode {
    public int value;
    public BTNode left;
    public BTNode right;

    public BTNode(int value) {
        this.value = value;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }
}
