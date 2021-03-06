package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.LNode;

class TwoLinkedListsSum {

    static LNode sumDirect(LNode valueA, LNode valueB) {
        int aLength = listLength(valueA);
        int bLength = listLength(valueB);

        if (aLength > bLength) {
            int zeros = aLength - bLength;
            while (zeros != 0) {
                valueB = prepend(valueB, 0);
                zeros--;
            }
        } else if (bLength > aLength) {
            int zeros = bLength - aLength;
            while (zeros != 0) {
                valueA = prepend(valueA, 0);
                zeros--;
            }
        }

        Data sum = sum(valueA, valueB);

        if (sum.rem > 0) prepend(sum.result, 1);

        return sum.result;
    }

    static Data sum(LNode listA, LNode listB) {
        if (listA == null || listB == null) {
            return new Data();
        } else {
            Data result = sum(listA.next, listB.next);

            int s = listA.value + listB.value + result.rem;

            if (result.result == null) {
                result.result = new LNode(0);
            } else {
                LNode node = LNode.node(0);
                node.next = result.result;
                result.result = node;
            }

            if (s >= 10) {
                result.rem = 1;
                result.result.value = s % 10;
            } else {
                result.rem = 0;
                result.result.value = s;
            }

            return result;
        }
    }

    static class Data {
        int rem;
        LNode result;
    }

    static LNode prepend(LNode head, int value) {
        LNode result = LNode.node(value);
        result.next = head;
        return result;
    }

    static int listLength(LNode list) {
        int result = 0;
        while (list != null) {
            result++;
            list = list.next;
        }
        return result;
    }

    static int sumReverse(LNode aNum, LNode bNum) {
        LNode sumRoot = new LNode(0);
        LNode current = sumRoot;
        int rem = 0;
        while (aNum != null && bNum != null) {
            int aValue = aNum.value;
            int bValue = bNum.value;
            int sum = aValue + bValue + current.value;

            if (sum <= 9) {
                current.value = sum;
                rem = 0;
            } else {
                current.value = sum - 10;
                rem = 1;
            }

            aNum = aNum.next;
            bNum = bNum.next;

            if (aNum != null && bNum != null) {
                current.next = new LNode(rem);
                current = current.next;
            }
        }

        LNode remNodes = null;
        if (aNum != null) remNodes = aNum;
        else if (bNum != null) remNodes = bNum;

        if (remNodes != null) {
            current.next = remNodes;
        }

        return toNum(sumRoot);
    }

    private static int toNum(LNode root) {
        int mult = 1;
        int result = 0;
        LNode node = root;
        while (node != null) {
            result += node.value * mult;
            mult *= 10;
            node = node.next;
        }

        return result;
    }
}
