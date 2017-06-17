package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 17/06/2017.
 */
public class QuickSort {

    public static int[] sort(int... unsorted) {
        sort(unsorted, 0, unsorted.length - 1);
        return unsorted;
    }

    private static void sort(int[] unsorted, int left, int right) {
        if (left >= right) return;
        int pos = split(unsorted, left, right);
        sort(unsorted, left, pos - 1);
        sort(unsorted, pos + 1, right);
    }

    private static int split(int[] unsorted, int left, int right) {

        int pivot = left;
        int l = left + 1;
        int r = right;
        while (l <= r) {

            if (unsorted[l] <= unsorted[pivot]) {
                l++;
                continue;
            }
            if (unsorted[r] > unsorted[pivot]) {
                r--;
                continue;
            }
            swap(unsorted, l++, r--);
        }
        if (unsorted[pivot] > unsorted[r]) {
            swap(unsorted, pivot, r);
            return r;
        }
        return pivot;

    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
