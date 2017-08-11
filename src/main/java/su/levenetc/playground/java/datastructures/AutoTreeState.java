package su.levenetc.playground.java.datastructures;

public class AutoTreeState {

    private StringBuilder state = new StringBuilder();
    private AutoTree rootNode;
    private AutoTree currentNode;

    public AutoTreeState(AutoTree roo) {

        this.rootNode = roo;
    }

    public void append(char ch) {
        state.append(ch);
        AutoTree node = rootNode.tryToComplete(state.toString());
        if (node != null) {
            currentNode = node;
        }
    }
}
