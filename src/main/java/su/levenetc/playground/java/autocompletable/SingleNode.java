package su.levenetc.playground.java.autocompletable;

import su.levenetc.playground.java.utils.Utils;

public class SingleNode extends BaseNode {

    String variant;

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
    public String toString() {
        return String.format("{%s}", variant);
    }

    public String getVariant() {
        return variant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SingleNode that = (SingleNode) o;

        return variant != null ? variant.equals(that.variant) : that.variant == null;
    }

    @Override
    public int hashCode() {
        return variant != null ? variant.hashCode() : 0;
    }
}
