package su.levenetc.playground.java.algs;

public class MergeSortedArrays {
    public static int[] mergeNew(int[] a, int[] b) {

        if (a.length == 0) return b;
        if (b.length == 0) return a;

        int[] result = new int[a.length + b.length];

        int indexA = 0;
        int indexB = 0;
        int index = 0;

        while (indexA < a.length || indexB < b.length) {

            if (indexA == a.length) {
                result[index] = b[indexB];
                indexB++;
                index++;
                continue;
            } else if (indexB == b.length) {
                result[index] = a[indexA];
                indexA++;
                index++;
                continue;
            }

            int valueA = a[indexA];
            int valueB = b[indexB];

            if (valueA < valueB) {
                result[index] = valueA;
                indexA++;
            } else {
                result[index] = valueB;
                indexB++;
            }
            index++;
        }

        return result;
    }

    /**
     * 1. Goes from back of arrays selecting larger values and putting them into spare places
     * 2. Copy rest values from source
     *
     * @param target
     * @param targetNum
     * @param source
     * @param sourceNum
     * @return
     */
    public static int[] mergeInto(int[] target, int targetNum, int[] source, int sourceNum) {

        int targetIndex = targetNum - 1;
        int sourceIndex = sourceNum - 1;
        int total = targetNum + sourceNum - 1;

        while (targetIndex >= 0 && sourceIndex >= 0) {
            if (source[sourceIndex] > target[targetIndex]) {
                target[total] = source[sourceIndex];
                sourceIndex--;
            } else {
                target[total] = target[targetIndex];
                targetIndex--;
            }
            total--;
        }

        while (sourceIndex >= 0) {
            target[total] = source[sourceIndex];
            sourceIndex--;
            total--;
        }

        return target;
    }
}