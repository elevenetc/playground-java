package su.levenetc.playground.java.autocompletable;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Contains current state of graph and makes basic operations
 */
public class GraphModel {

    private Completable root;
    private Completable last;
    private LinkedList<Completable> stack = new LinkedList<>();

    public static GraphModel from(Completable root) {
        return new GraphModel(root);
    }

    public GraphModel(Completable root) {
        this.root = root;
        last = root;
    }

    public Editor change(int tag) {
        for (Completable node : stack) {
            Completable parent = node.getParent();
            if (parent instanceof ArrayNode) {
                ArrayNode array = (ArrayNode) parent;
                if (array.getTag() == tag) {
                    return new Editor(array, node, this);
                }
            }
        }
        return null;
    }

    public GraphModel pop() {
        stack.pop();
        last = stack.peek();
        return this;
    }

    public GraphModel completeAndNext(String value) {
        last = last.completeAndNext(value);
        stack.push(last);
        return this;
    }

    public GraphModel completeCurrent(String value) {
        last = last.complete(value);
        stack.push(last);
        return this;
    }

    public Completable root() {
        return last;
    }

    public Completable last() {
        return last;
    }

    public Deque<Completable> stack() {
        return stack;
    }

    private void replace(Completable from, Completable to) {
        for (Completable node : stack) {
            if (node == from) {
                int i = stack.indexOf(node);
                stack.set(i, to);
                last = stack.peek();
                break;
            }
        }
    }

    public static class Editor {

        private final ArrayNode array;
        private final Completable nodeToChange;
        private final GraphModel graphModel;

        Editor(ArrayNode array, Completable nodeToChange, GraphModel graphModel) {

            this.array = array;
            this.nodeToChange = nodeToChange;
            this.graphModel = graphModel;
        }

        public void to(String newVariant) {
            for (Completable variant : array.getVariants()) {
                if (variant instanceof SingleNode) {
                    SingleNode sNode = (SingleNode) variant;
                    if (newVariant.equals(sNode.getVariant())) {
                        graphModel.replace(nodeToChange, sNode);
                        break;
                    }
                }
            }
        }
    }
}
