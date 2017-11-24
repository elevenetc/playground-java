package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.ListNode;

class TwoLinkedListsSum {

    static ListNode sumDirect(ListNode valueA, ListNode valueB) {
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

    static Data sum(ListNode listA, ListNode listB) {
        if (listA == null || listB == null) {
            return new Data();
        } else {
            Data result = sum(listA.next, listB.next);

            int s = listA.value + listB.value + result.rem;

            if (result.result == null) {
                result.result = new ListNode(0);
            } else {
                ListNode node = ListNode.node(0);
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
        ListNode result;
    }

    static ListNode prepend(ListNode head, int value) {
        ListNode result = ListNode.node(value);
        result.next = head;
        return result;
    }

    static int listLength(ListNode list) {
        int result = 0;
        while (list != null) {
            result++;
            list = list.next;
        }
        return result;
    }

    static int sumReverse(ListNode aNum, ListNode bNum) {
        ListNode sumRoot = new ListNode(0);
        ListNode current = sumRoot;
        int rem = 0;
        while (aNum != null && bNum != null) {
            int aValue = aNum.value;//5
            int bValue = bNum.value;//4
            int sum = aValue + bValue + current.value;//9

            if (sum <= 9) {
                current.value = sum;//9
                rem = 0;
            } else {
                current.value = sum - 10;
                rem = 1;
            }

            aNum = aNum.next;
            bNum = bNum.next;

            if (aNum != null && bNum != null) {
                current.next = new ListNode(rem);
                current = current.next;
            }
        }

        ListNode remNodes = null;
        if (aNum != null) remNodes = aNum;
        else if (bNum != null) remNodes = bNum;

        if (remNodes != null) {
            current.next = remNodes;
        }

        return toNum(sumRoot);
    }

    private static int toNum(ListNode root) {
        int mult = 1;
        int result = 0;
        ListNode node = root;
        while (node != null) {
            result += node.value * mult;
            mult *= 10;
            node = node.next;
        }

        return result;
    }
}
