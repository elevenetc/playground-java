package su.levenetc.playground.java.autocompletable;

import java.util.Deque;
import java.util.LinkedList;

public class GraphCursor {

    private Completable root;
    private Completable last;
    private LinkedList<Completable> stack = new LinkedList<>();

    public GraphCursor(Completable root) {
        this.root = root;
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

    public GraphCursor pop() {
        stack.pop();
        last = stack.peek();
        return this;
    }

    public GraphCursor completeAndNext(String value) {
        Completable complete;
        if (last == null) {
            complete = root.complete(value);
            last = root.completeAndNext(value);
        } else {
            complete = last.complete(value);
            last = last.completeAndNext(value);
        }
        stack.push(complete);
        return this;
    }

    public GraphCursor complete(String value) {
        Completable complete;
        if (last == null) {
            complete = root.complete(value);
            last = root.complete(value);
        } else {
            complete = last.complete(value);
            last = last.complete(value);
        }
        stack.push(complete);
        return this;
    }

    public Completable last() {
        return last;
    }

    public Deque<Completable> stack() {
        return stack;
    }

    private void replace(Completable from, Completable to) {
        for (Completable node : stack) {
            if(node == from){
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
        private final GraphCursor graphCursor;

        public Editor(ArrayNode array, Completable nodeToChange, GraphCursor graphCursor) {

            this.array = array;
            this.nodeToChange = nodeToChange;
            this.graphCursor = graphCursor;
        }

        public void to(String newVariant) {
            for (Completable variant : array.getVariants()) {
                if (variant instanceof SingleNode) {
                    SingleNode sNode = (SingleNode) variant;
                    if (newVariant.equals(sNode.getVariant())) {
                        graphCursor.replace(nodeToChange, sNode);
                        break;
                    }
                }
            }
        }
    }
}
