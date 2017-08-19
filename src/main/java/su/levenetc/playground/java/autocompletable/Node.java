package su.levenetc.playground.java.autocompletable;

public interface Node {

    Node complete(String value);

    void setNext(Node node);

    void setPrev(Node node);

    void setParent(Node parent);

    Node getPrev();

    Node getNext();

    Node getParent();
}
