package su.levenetc.playground.java.autocompletable;

import java.util.Deque;
import java.util.LinkedList;

public class TreeCursor {

    private Completable root;
    private Completable current;
    private Deque<Completable> stack = new LinkedList<>();

    public TreeCursor(Completable root) {
        this.root = root;
    }

    public TreeCursor pop() {
        stack.pop();
        current = stack.peek();
        return this;
    }

    public TreeCursor completeAndNext(String value) {
        Completable complete;
        if (current == null) {
            complete = root.complete(value);
            current = root.completeAndNext(value);
        } else {
            complete = current.complete(value);
            current = current.completeAndNext(value);
        }
        stack.push(complete);
        return this;
    }

    public TreeCursor complete(String value) {
        Completable complete;
        if (current == null) {
            complete = root.complete(value);
            current = root.complete(value);
        } else {
            complete = current.complete(value);
            current = current.complete(value);
        }
        stack.push(complete);
        return this;
    }

    public Completable current() {
        return current;
    }

    public Deque<Completable> stack() {
        return stack;
    }
}
