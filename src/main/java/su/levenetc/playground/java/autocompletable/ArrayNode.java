package su.levenetc.playground.java.autocompletable;

import java.util.List;

public class ArrayNode implements Completable {


    private Completable prev;
    private Completable next;
    private List<Completable> variants;
    private TYPE type;

    public ArrayNode(List<Completable> variants, TYPE type) {
        this.variants = variants;
        this.type = type;
    }

    @Override
    public Completable complete(String value) {
        for (Completable variant : variants) {
            Completable complete = variant.complete(value);
            if (complete != null) {
                return complete;
            }
        }
        return null;
    }

    @Override
    public Completable completeAndNext(String value) {
        for (Completable variant : variants) {
            Completable complete = variant.completeAndNext(value);
            if (complete != null) {
                return complete;
            }
        }
        return null;
    }

    @Override
    public void setNext(Completable next) {

        this.next = next;
        for (Completable variant : variants) {
            variant.setNext(next);
        }
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

    enum TYPE {
        SINGLE,
        MULTIPLE
    }
}
