package su.levenetc.playground.java.autocompletable;

import java.util.List;

public class ForkNode extends BaseNode {

    private List<Node> variants;

    public ForkNode(List<Node> variants) {

        this.variants = variants;
    }

    @Override
    public Node complete(String value) {
        for (Node variant : variants) {
            Node complete = variant.complete(value);
            if (complete != null) {
                return complete;
            }
        }
        return null;
    }

    @Override
    public void setNext(Node next) {
        super.setNext(next);
        for (Node variant : variants) {
            variant.setNext(next);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0, variantsSize = variants.size(); i < variantsSize; i++) {
            Node variant = variants.get(i);
            sb.append(variant.toString());
            if (i < variantsSize - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}
