package su.levenetc.playground.java.algs.pathfinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene.levenetc on 10/11/2016.
 */
public class BreadthFirstSearch implements PathAlg {

    private AbstractNode[][] graph;

    @Override
    public void setGraph(AbstractNode[][] graph) {
        this.graph = graph;
    }

    @Override
    public List<AbstractNode> find(AbstractNode from, AbstractNode to) {
        final ArrayList<AbstractNode> result = new ArrayList<>();
        if (from.equals(to)) result.add(to);
        else find(result);
        return result;
    }

    private List<AbstractNode> find(List<AbstractNode> source) {
        return null;
    }
}