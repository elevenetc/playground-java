package su.levenetc.playground.java.autocompletable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BranchBuilder {

    Completable current;

    public BranchBuilder isOptional() {
        //TODO: set current as optional
        return this;
    }

    public BranchBuilder dependOn(int tag) {
        //TODO: set current depend on tag
        //TODO: pass hashmap as dependency map
        return this;
    }

    public BranchBuilder switchByTag(int tag, String variant) {
        //TODO: find and switch selected by tag: name to age
        return this;
    }

    public BranchBuilder thenMultiple(String... variants) {
        return then(ArrayNode.TYPE.MULTIPLE, -1, variants);
    }

    public BranchBuilder thenMultiple(int tag, String... variants) {
        return then(ArrayNode.TYPE.MULTIPLE, tag, variants);
    }

    public BranchBuilder thenOneOf(String... variants) {
        return then(ArrayNode.TYPE.SINGLE, -1, variants);
    }

    public BranchBuilder thenOneOf(int tag, String... variants) {
        return then(ArrayNode.TYPE.SINGLE, tag, variants);
    }

    private BranchBuilder then(ArrayNode.TYPE type, int tag, String... variants) {

        List<Completable> vars = new LinkedList<>();
        for (String variant : variants) vars.add(new SingleNode(variant));

        ArrayNode node = new ArrayNode(vars, type);
        node.setTag(tag);

        if (current == null) {
            current = node;
        } else {
            current.setNext(node);
            node.setPrev(current);
            current = node;
        }

        return this;
    }

    public static BranchBuilder from(Completable... completable) {
        ForkNode node = new ForkNode(Arrays.asList(completable));
        BranchBuilder builder = new BranchBuilder();
        builder.current = node;
        return builder;
    }

    public static BranchBuilder from(String variant) {
        SingleNode root = new SingleNode(variant);
        BranchBuilder builder = new BranchBuilder();
        builder.current = root;
        return builder;
    }

    public BranchBuilder then(String variant) {

        SingleNode node = new SingleNode(variant);

        if (current == null) {
            current = node;
        } else {
            current.setNext(node);
            node.setPrev(current);
            current = node;
        }

        return this;
    }

    public BranchBuilder thenMultiple(Completable... completable) {
        return then(ArrayNode.TYPE.MULTIPLE, completable);
    }

    public BranchBuilder thenOneOf(Completable... completable) {
        return then(ArrayNode.TYPE.SINGLE, completable);
    }

    private BranchBuilder then(ArrayNode.TYPE type, Completable... completable) {

        if (current == null) {
            current = new ArrayNode(Arrays.asList(completable), type);
        } else {
            ArrayNode node = new ArrayNode(Arrays.asList(completable), type);
            current.setNext(node);
            node.setPrev(current);
        }

        return this;
    }

    public Completable isLast() {
        return getRoot(current);
    }

    private Completable getRoot(Completable node) {
        if (node.getPrev() == null) {
            return node;
        } else {
            return getRoot(node.getPrev());
        }
    }
}
