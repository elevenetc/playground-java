package su.levenetc.playground.java.autocompletable;

public abstract class BaseNode implements Node {

    protected Node prev;
    protected Node next;
    protected Node parent;
    protected int tag;

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    @Override
    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    @Override
    public Node getPrev() {
        return prev;
    }

    @Override
    public Node getNext() {
        return next;
    }

    @Override
    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public Node getParent() {
        return parent;
    }
}
