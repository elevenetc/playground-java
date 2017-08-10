package su.levenetc.playground.java.datastructures;

import java.util.Arrays;
import java.util.List;

public class AutoTree {

    private List<String> variants;
    private AutoTree next;
    private AutoTree prev;
    private boolean optional;

    public AutoTree(String... variants) {
        this.variants = Arrays.asList(variants);
    }

    public AutoTree next() {
        return next;
    }

    public AutoTree autocomplete(String value) {
        AutoTree result = isCompletable(value);
        return result == null ? this : result;
    }

    public AutoTree isCompletable(String value) {
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

    public String name() {
        return variants.get(0);
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

    public static List<AutoTree> or(AutoTree... branches) {
        for (int i = 0; i < branches.length; i++) {
            branches[i] = getRoot(branches[i]);
        }
        return Arrays.asList(branches);
    }

    public static AutoTree branch(String variant) {
        return new AutoTree(variant);
    }

    public static AutoTree array(String... variant) {
        return new AutoTree(variant);
    }
}

