package su.levenetc.playground.java.autocompletable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BranchBuilder {

    Completable current;

    public BranchBuilder then(String... variants) {
        return then(-1, variants);
    }

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

    public BranchBuilder then(int tag, String... variants) {

        List<Completable> vars = new LinkedList<>();
        for (String variant : variants) vars.add(new SingleNode(variant));

        ForkNode node = new ForkNode(vars);//TODO: replace with ArrayNode?

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

    public BranchBuilder then(Completable... completable) {

        if (current == null) {
            current = new ForkNode(Arrays.asList(completable));
        } else {
            ForkNode node = new ForkNode(Arrays.asList(completable));
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
