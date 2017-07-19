package su.levenetc.playground.java.algs;

public class MedianOfTwoSortedArrays {

    public static float get(int[] a, int[] b) {
        final int length = a.length + b.length;
        final boolean even = length % 2 == 0;
        int target = length / 2;

        if (even) {
            target -= 1;
        }

        int pointA = 0;
        int pointB = 0;
        int current = 0;
        int[] pointers = new int[3];
        boolean[] results = new boolean[3];

        while (pointA < a.length || pointB < b.length) {

            shift(a, b, pointers, results);

            pointA = pointers[0];
            pointB = pointers[1];
            current = pointers[2];

            boolean aChanged = results[0];
            boolean bChanged = results[1];
            boolean bothChanged = results[2];

            if (current == target) {

                if (even) {

                    int firstValue;

                    if (aChanged) firstValue = a[pointA];
                    else if (bChanged) firstValue = b[pointB];
                    else firstValue = a[pointA];

                    final int secondValue = next(aChanged, bChanged, a, b, pointers);

                    return (firstValue + secondValue) / 2f;

                } else {
                    if (aChanged) return a[pointA];
                    if (bChanged) return b[pointB];
                    if (bothChanged) return a[pointA];
                }
            }

            if (pointA == a.length) {
                break;
            }

            if (pointB == b.length) {
                break;
            }
        }

        return 0;
    }

    static int next(boolean aChanged, boolean bChanged, int[] a, int[] b, int[] pointers) {
        if (aChanged) {
            if (pointers[0] == a.length - 1) {//if last
                return b[pointers[1]];
            } else {
                pointers[0]++;
                pointers[1]++;
                return Math.min(a[pointers[0]], b[pointers[1]]);
            }
        } else {//bChanged
            if (pointers[1] == b.length - 1) {
                return a[pointers[0]];
            } else {
                pointers[0]++;
                pointers[1]++;
                return Math.min(a[pointers[0]], b[pointers[1]]);
            }
        }
    }

    static void shift(int[] a, int[] b, int[] pointers, boolean[] shiftResult) {

        shiftResult[0] = false;
        shiftResult[1] = false;
        shiftResult[2] = false;

        int pointA = pointers[0];
        int pointB = pointers[1];
        int current = pointers[2];

        if (pointA < a.length && pointB < b.length) {
            if (a[pointA] < b[pointB]) {
                shiftResult[0] = true;
                pointA++;
            } else if (a[pointA] > b[pointB]) {
                shiftResult[1] = true;
                pointB++;
            } else {
                shiftResult[2] = true;
                pointA++;
                pointB++;
            }
            current++;
        } else if (pointA < a.length) {
            pointA++;
            current++;
        } else if (pointB < b.length) {
            pointB++;
            current++;
        }

        pointers[0] = pointA;
        pointers[1] = pointB;
        pointers[2] = current;
    }

}
