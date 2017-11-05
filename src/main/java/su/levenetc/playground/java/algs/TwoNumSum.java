package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.IntNode;

public class TwoNumSum {
    public static int sumReverse(IntNode aNum, IntNode bNum) {
        IntNode sumRoot = new IntNode(0);
        IntNode current = sumRoot;
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
                current.next = new IntNode(rem);
                current = current.next;
            }
        }

        IntNode remNodes = null;
        if (aNum != null) remNodes = aNum;
        else if (bNum != null) remNodes = bNum;

        if (remNodes != null) {
            current.next = remNodes;
        }

        return toNum(sumRoot);
    }

    private static int toNum(IntNode root) {
        int mult = 1;
        int result = 0;
        IntNode node = root;
        while (node != null) {
            result += node.value * mult;
            mult *= 10;
            node = node.next;
        }

        return result;
    }
}
