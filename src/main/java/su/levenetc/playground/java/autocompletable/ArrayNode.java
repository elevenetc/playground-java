package su.levenetc.playground.java.autocompletable;

import java.util.List;

public class ArrayNode extends BaseNode {

    private List<Node> variants;
    private TYPE type;

    public ArrayNode(List<Node> variants, TYPE type) {
        this.variants = variants;
        this.type = type;
        for (Node variant : variants) {
            variant.setParent(this);
        }
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

    public List<Node> getVariants() {
        return variants;
    }

    enum TYPE {
        SINGLE,
        MULTIPLE
    }
}
