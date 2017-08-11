package su.levenetc.playground.java.autocompletable;

public interface Completable {

    Completable complete(String value);

    Completable completeAndNext(String value);

    void setNext(Completable completable);

    void setPrev(Completable completable);

    Completable getPrev();

    Completable getNext();
}
