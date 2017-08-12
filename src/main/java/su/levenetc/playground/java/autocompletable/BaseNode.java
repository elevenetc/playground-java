package su.levenetc.playground.java.autocompletable;

public abstract class BaseNode implements Completable {

    protected Completable prev;
    protected Completable next;
    protected Completable parent;
    protected int tag;

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    @Override
    public void setNext(Completable next) {
        this.next = next;
    }

    @Override
    public void setPrev(Completable prev) {
        this.prev = prev;
    }

    @Override
    public Completable getPrev() {
        return prev;
    }

    @Override
    public Completable getNext() {
        return next;
    }

    @Override
    public void setParent(Completable parent) {
        this.parent = parent;
    }

    @Override
    public Completable getParent() {
        return parent;
    }
}
