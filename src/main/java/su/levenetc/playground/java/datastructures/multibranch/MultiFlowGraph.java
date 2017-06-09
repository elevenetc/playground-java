package su.levenetc.playground.java.datastructures.multibranch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import su.levenetc.playground.java.datastructures.multibranch.parts.ForkNode;
import su.levenetc.playground.java.datastructures.multibranch.parts.QueueNode;
import su.levenetc.playground.java.utils.Out;

/**
 * Created by eugene.levenetc on 07/06/2017.
 */
public class MultiFlowGraph {

    public BaseFlowNode startWith(BaseFlowNode root) {
        final LinkedList<BaseFlowNode> rootBranch = new LinkedList<>();
        rootBranch.add(root);
        return root;
    }

    void goTo(BaseFlowNode from, Class<? extends BaseFlowNode> target) {

    }

    public void goToNext(BaseFlowNode from) {

    }

    public void then(FlowNode from, FlowNode to) {

        //prependOrAppend(from, to);

        Out.pln("Then: " + from + " to " + to);
    }

    public ForkNode thenOneOf(BaseFlowNode from, FlowNode... next) {

        ForkNode fork = new ForkNode();
        fork.from = from;

        for (FlowNode node : next) {
            if (node instanceof QueueNode) {
                fork.paths.add(((QueueNode) node).queue);
            } else if (node instanceof BaseFlowNode) {
                List<FlowNode> list = new LinkedList<>();
                list.add(node);
                fork.paths.add(list);
            }
        }


        Out.pln("ThenOnOf: " + from + " to " + Arrays.toString(next));

        return fork;
    }

}