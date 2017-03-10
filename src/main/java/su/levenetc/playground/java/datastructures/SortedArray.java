package su.levenetc.playground.java.datastructures;

/**
 * Created by eugene.levenetc on 10/03/2017.
 */
public class SortedArray {

    private int[] array;
    private int lastIndex;
    private int size;

    public SortedArray(int size) {
        array = new int[size];
    }

    public int[] getArray() {
        return array;
    }

    public int get(int index) {
        return array[index];
    }

    public void add(int value) {
        if (size == 0) {
            array[lastIndex] = value;
            size = 1;
        } else {
            addAndSort(value);
        }
    }

    private void addAndSort(int value) {
        if (array[lastIndex] <= value) {
            array[++lastIndex] = value;
        } else {
            if (size == 1) {
                addSecond(value);
            } else {
                int i = searchForInsertionIndex(value, 0, lastIndex);
                System.arraycopy(array, i, array, i + 1, lastIndex - i + 1);
                array[i] = value;
            }

            lastIndex++;
        }
        size = lastIndex + 1;
    }

    private void addSecond(int value) {
        if (value < array[0]) {
            array[1] = array[0];
            array[0] = value;
        } else if (value >= array[0]) {
            array[1] = value;
        }
    }

    private int searchForInsertionIndex(int value, int min, int max) {
        if (min == max) return min;
        int length = max - min + 1;
        boolean isEven = length % 2 == 0;

        if (isEven) {
            int left = length / 2 + min - 1;
            int right = length / 2 + min;

            if (value < array[left]) {
                return searchForInsertionIndex(value, min, left);
            } else if (value > array[right]) {
                return searchForInsertionIndex(value, right, max);
            } else {
                return right;
            }
        } else {
            int mid = length / 2;

            if (value < array[mid]) {
                return searchForInsertionIndex(value, min, mid);
            } else if (value > array[mid]) {
                return searchForInsertionIndex(value, mid, max);
            } else {
                return mid;
            }
        }
    }
}