package su.levenetc.playground.java.datastructures.multibranch;

import su.levenetc.playground.java.datastructures.multibranch.parts.ForkNode;
import su.levenetc.playground.java.utils.Out;

/**
 * Created by eugene.levenetc on 07/06/2017.
 */
public class MultiFlowGraph {

    private FlowNode root;
    private FlowNode current;

    public FlowNode startWith(FlowNode root) {
        this.root = root;
        return root;
    }

    public FlowNode getCurrent() {
        return current;
    }

    public void start() {
        current = root;
    }

    public void next() {
        current = current.next();
    }

    public boolean isFork() {
        return current instanceof ForkNode;
    }

    void goTo(BaseFlowNode from, Class<? extends BaseFlowNode> target) {

    }

    public void goToNext(BaseFlowNode from) {

    }

    public void then(FlowNode from, FlowNode to) {

        //prependOrAppend(from, to);

        Out.pln("Then: " + from + " to " + to);
    }

}