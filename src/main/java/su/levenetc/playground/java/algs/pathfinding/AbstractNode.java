package su.levenetc.playground.java.algs.pathfinding;

/**
 * Created by eugene.levenetc on 10/11/2016.
 */
public class AbstractNode<T> {

    private final int x;
    private final int y;
    private T value;

    public AbstractNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
