package su.levenetc.playground.java.datastructures.multibranch;

/**
 * Created by eugene.levenetc on 09/06/2017.
 */
public interface FlowNode {
    FlowNode then(FlowNode next);

    FlowNode next();

    FlowNode prev();

    void setPrev(FlowNode prev);

    void setNext(FlowNode next);
}