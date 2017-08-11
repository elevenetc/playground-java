package su.levenetc.playground.java.autocompletable;

import su.levenetc.playground.java.utils.Utils;

public class SingleNode implements Completable {

    String variant;
    Completable next;
    Completable prev;

    public SingleNode(String variant) {
        this.variant = variant;
    }

    @Override
    public Completable complete(String value) {
        if (Utils.isCompletable(value, value)) return this;
        else return null;
    }

    @Override
    public Completable completeAndNext(String value) {
        if (Utils.isCompletable(value, value)) {
            return next;
        } else {
            return null;
        }
    }

    @Override
    public void setNext(Completable completable) {
        next = completable;
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
        return String.format("{%s}", variant);
    }

    public String getVariant() {
        return variant;
    }
}
