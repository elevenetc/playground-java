package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.RNode;

public class CloneRandomLinkedList {
    public static RNode clone(RNode list) {

        if (list == null) return null;

        RNode result = null;
        RNode current = list;

        //create copies
        while (current != null) {
            RNode clone = new RNode(current.value);
            clone.clone = true;
            clone.next = current.next;
            current.next = clone;

            current = current.next.next;
        }

        current = list;

        //set rnd
        while (current != null) {
            RNode clone = current.next;
            clone.rnd = current.rnd.next;

            current = current.next.next;
        }

        current = list;
        RNode cloneNode = null;
        //decouple clones
        while (current != null) {
            RNode clone = current.next;
            current.next = clone.next;

            if (result == null) {
                result = clone;
                cloneNode = result;
            } else {
                cloneNode.next = clone;
                cloneNode = clone;
            }

            current = current.next;
        }

        return result;
    }
}
