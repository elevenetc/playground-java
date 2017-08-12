package su.levenetc.playground.java.autocompletable;

import java.util.List;

public class ArrayNode extends BaseNode {

    private List<Completable> variants;
    private TYPE type;

    public ArrayNode(List<Completable> variants, TYPE type) {
        this.variants = variants;
        this.type = type;
        for (Completable variant : variants) {
            variant.setParent(this);
        }
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
        super.setNext(next);
        for (Completable variant : variants) {
            variant.setNext(next);
        }
    }

    public List<Completable> getVariants() {
        return variants;
    }

    enum TYPE {
        SINGLE,
        MULTIPLE
    }
}
