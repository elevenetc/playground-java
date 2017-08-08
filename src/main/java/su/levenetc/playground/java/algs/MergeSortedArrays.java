package su.levenetc.playground.java.algs;

public class MergeSortedArrays {
    public static int[] merge(int[] a, int[] b) {

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
}