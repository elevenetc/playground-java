package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 17/06/2017.
 */
public class QuickSort {

    public static int[] sort(int... unsorted) {
        splitAndSort(unsorted, 0, unsorted.length - 1);
        return unsorted;
    }

    private static void splitAndSort(int[] unsorted, int left, int right) {
        if (left >= right) return;
        int pos = sort(unsorted, left, right);
        splitAndSort(unsorted, left, pos - 1);
        splitAndSort(unsorted, pos + 1, right);
    }

    private static int sort(int[] unsorted, int left, int right) {

        final int pivot = left;
        final int pivotValue = unsorted[pivot];
        int l = left + 1;
        int r = right;

        while (l <= r) {

            if (unsorted[l] <= pivotValue) {
                l++;
            } else if (unsorted[r] > pivotValue) {
                r--;
            } else {
                swap(unsorted, l, r);
                l++;
                r++;
            }

        }
        if (pivotValue > unsorted[r]) {
            swap(unsorted, pivot, r);
            return r;
        } else {
            return pivot;
        }

    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
