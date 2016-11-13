package su.levenetc.playground.java.algs.pathfinding;

import java.util.List;

/**
 * Created by eugene.levenetc on 10/11/2016.
 */
public interface PathAlg {
    void setGraph(AbstractNode[][] graph);

    List<AbstractNode> find(AbstractNode from, AbstractNode to);
}
