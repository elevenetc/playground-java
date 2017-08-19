package su.levenetc.playground.java.datastructures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AutoTree {

    private List<String> variants;
    private AutoTree next;
    private AutoTree prev;

    private String selected;

    public AutoTree(String... variants) {
        //TODO: add AutoTree array constructor
        this.variants = Arrays.asList(variants);
    }

    public AutoTree next() {
        return next;
    }

    public AutoTree complete(String value) {
        return tryToComplete(value);
    }

    public AutoTree tryToComplete(String value) {

        char[] toComplete = value.toCharArray();
        for (String variant : variants) {
            char[] variantChars = variant.toCharArray();
            if (toComplete.length > variantChars.length) continue;
            boolean invalid = false;
            for (int i = 0; i < toComplete.length; i++) {
                char ch = toComplete[i];
                if (ch != variantChars[i]) {
                    invalid = true;
                    break;
                }
            }
            if (invalid) continue;
            selected = variant;
            return next;
        }
        return null;
    }

    public AutoTree then(AutoTree node) {
        next = node;
        next.prev = this;
        return next;
    }

    public AutoTree then(String... variant) {
        next = new AutoTree(variant);
        next.prev = this;
        return next;
    }

    public List<String> buildBranch() {
        List<String> result = new LinkedList<>();
        AutoTree p = prev;
        while (p != null) {
            result.add(p.selected);
            p = p.prev;
        }
        return result;
    }

    @Override
    public String toString() {

        String[] lll = new String[variants.size()];
        for (int i = 0; i < variants.size(); i++) {
            lll[i] = variants.get(i);
        }

        return Arrays.toString(lll);
    }

    private static AutoTree getRoot(AutoTree node) {
        final AutoTree prev = node.prev;
        if (prev == null) return node;
        return getRoot(prev);
    }

    public static List or(AutoTree... branches) {
        for (int i = 0; i < branches.length; i++) {
            branches[i] = getRoot(branches[i]);
        }
        return Arrays.asList(branches);
    }

    public static AutoTree branch(String variant) {
        return new AutoTree(variant);
    }

    public static AutoTree array(String... variant) {
        AutoTree autoTree = new AutoTree(variant);
        return autoTree;
    }
}

