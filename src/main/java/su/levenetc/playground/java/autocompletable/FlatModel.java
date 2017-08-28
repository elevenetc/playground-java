package su.levenetc.playground.java.autocompletable;

import java.util.Deque;
import java.util.LinkedList;

import static su.levenetc.playground.java.autocompletable.FlatModel.NodeWrapper.completed;
import static su.levenetc.playground.java.autocompletable.FlatModel.NodeWrapper.notCompleted;

/**
 * Contains current state of graph and makes basic operations
 */
public class FlatModel {

    private Node root;
    /**
     * Could be null
     */
    private Node last;
    /**
     * Could be empty
     */
    private LinkedList<NodeWrapper> list = new LinkedList<>();

    public static FlatModel from(Node root) {
        return new FlatModel(root);
    }

    public FlatModel(Node root) {
        this.root = root;
    }

    public Editor change(int tag) {
        for (NodeWrapper wrapper : list) {
            Node node = wrapper.node;
            Node parent = node.getParent();
            if (parent instanceof ArrayNode) {
                ArrayNode array = (ArrayNode) parent;
                if (array.getTag() == tag) {
                    return new Editor(array, node, this);
                }
            }
        }
        return null;
    }

    public FlatModel pop() {
        list.pop();
        //last = list.peek();
        return this;
    }

    public boolean append(String value) {
        if (list.isEmpty()) {
            Node complete = root.complete(value);
            if (complete != null) {
                list.add(completed(complete, value));
                addNextIfExists();
                return true;
            } else {
                list.add(notCompleted(root));
            }
        } else {
            NodeWrapper last = list.getLast();
            Node complete = last.node.complete(value);
            if (complete != null) {

            }
        }
        //return this;
        return true;
    }

    private void addNextIfExists() {
        NodeWrapper last = list.getLast();
        Node next = last.node.getNext();
        if (next != null) {
            list.add(notCompleted(next));
        }

    }

    public Node root() {
        return last;
    }

    public Node last() {
        return last;
    }

    public Deque<Node> stack() {
        //return list;
        return null;
    }

    private void replace(Node from, Node to) {
        for (NodeWrapper wrapper : list) {
            Node node = wrapper.node;
            if (node == from) {
                int i = list.indexOf(node);
                //list.set(i, to);
                //last = list.peek();
                break;
            }
        }
    }

    public static class Editor {

        private final ArrayNode array;
        private final Node nodeToChange;
        private final FlatModel flatModel;

        Editor(ArrayNode array, Node nodeToChange, FlatModel flatModel) {

            this.array = array;
            this.nodeToChange = nodeToChange;
            this.flatModel = flatModel;
        }

        public void to(String newVariant) {
            for (Node variant : array.getVariants()) {
                if (variant instanceof SingleNode) {
                    SingleNode sNode = (SingleNode) variant;
                    if (newVariant.equals(sNode.getVariant())) {
                        flatModel.replace(nodeToChange, sNode);
                        break;
                    }
                }
            }
        }
    }

    static class NodeWrapper {

        Node node;
        boolean isCompleted;
        String variant = "";

        public NodeWrapper(Node node, boolean isCompleted, String variant) {
            this.node = node;
            this.isCompleted = isCompleted;
            this.variant = variant;
        }

        static NodeWrapper completed(Node node, String variant) {
            return new NodeWrapper(node, true, variant);
        }

        static NodeWrapper notCompleted(Node node) {
            return new NodeWrapper(node, false, "");
        }
    }
}
