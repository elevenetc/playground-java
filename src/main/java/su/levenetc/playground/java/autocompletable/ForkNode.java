package su.levenetc.playground.java.autocompletable;

import java.util.List;

public class ForkNode implements Completable {


    private List<Completable> variants;
    Completable prev;
    Completable next;

    public ForkNode(List<Completable> variants) {

        this.variants = variants;
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
    public void setNext(Completable completable) {
        next = completable;
        for (Completable variant : variants) {
            variant.setNext(completable);
        }
    }

    @Override
    public void setPrev(Completable completable) {
        prev = completable;
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0, variantsSize = variants.size(); i < variantsSize; i++) {
            Completable variant = variants.get(i);
            sb.append(variant.toString());
            if (i < variantsSize - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}
