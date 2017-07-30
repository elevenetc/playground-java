package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.utils.Out;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class MedianOfTwoSortedArrays {

    public static double ver1(int[] a, int[] b) {

        int total = a.length + b.length;
        if (total % 2 == 0) {
            final int midA = total / 2 + 1;
            final int mibB = total / 2;
            return (ver1Median(midA, a, b, 0, 0) + ver1Median(mibB, a, b, 0, 0)) / 2.0;
        } else {
            final int mid = total / 2 + 1;
            return ver1Median(mid, a, b, 0, 0);
        }
    }

    private static int ver1Median(int half, int[] a, int[] b, int indexA, int indexB) {

        if (indexA >= a.length)
            return b[indexB + half - 1];

        if (indexB >= b.length)
            return a[indexA + half - 1];

        if (half == 1)
            return min(a[indexA], b[indexB]);

        int aIndex = indexA + half / 2 - 1;
        int bIndex = indexB + half / 2 - 1;

        int aValue = aIndex < a.length ? a[aIndex] : Integer.MAX_VALUE;
        int bValue = bIndex < b.length ? b[bIndex] : Integer.MAX_VALUE;

        final int newIndex = half - half / 2;

        if (aValue < bValue) {
            return ver1Median(newIndex, a, b, aIndex + 1, indexB);
        } else {
            return ver1Median(newIndex, a, b, indexA, bIndex + 1);
        }
    }

    public static double ver2(int a[], int b[]) {

        int aLen = a.length;
        int bLen = b.length;

        if ((aLen + bLen) % 2 == 0) {
            final int commonMidLeft = (aLen + bLen) / 2 - 1;
            final int commonMidRight = (aLen + bLen) / 2;
            final int left = ver2Median(a, b, commonMidLeft, 0, aLen - 1, 0, bLen - 1);
            final int right = ver2Median(a, b, commonMidRight, 0, aLen - 1, 0, bLen - 1);
            return (right + left) / 2f;
        } else {
            final int mid = (aLen + bLen) / 2;
            return (double) ver2Median(a, b, mid, 0, aLen - 1, 0, bLen - 1);
        }
    }

    private static int ver2Median(int a[], int b[], int mid, int aStart, int aEnd, int bStart, int bEnd) {

        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        // Handle special cases
        if (aLen == 0) {
            Out.pln("aLen=0, exit");
            return b[bStart + mid];
        }
        if (bLen == 0) {
            Out.pln("bLen=0, exit");
            return a[aStart + mid];
        }
        if (mid == 0) {
            Out.pln("mid=0, exit");
            return a[aStart] < b[bStart] ? a[aStart] : b[bStart];
        }

        int aMid = (aLen * mid) / (aLen + bLen); // a's middle count
        int bMid = mid - aMid - 1; // b's middle count

        // make aMid and bMid to be array index
        aMid = aMid + aStart;
        bMid = bMid + bStart;

//        Out.pln();
//        Out.pln("mid at", mid);
//        Out.plnRange(" a", a, aStart, aEnd, aMid);
//        Out.plnRange(" b", b, bStart, bEnd, bMid);
//        Out.pln();

        if (a[aMid] > b[bMid]) {
            mid = mid - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            mid = mid - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }

        return ver2Median(a, b, mid, aStart, aEnd, bStart, bEnd);
    }

    public static float ver3(int[] a, int[] b) {
        if (a.length > b.length) {
            int[] tmp = a;
            a = b;
            b = tmp;
        }
        return ver3Median(a, 0, a.length, b, 0, b.length);
    }

    static float ver3Median(int a[], int aStart, int aEnd, int b[], int bStart, int bEnd) {
        // If smaller array is empty, return median from second array


        if (aEnd == 0) return getMedian(b, bEnd);

        // If the smaller array has only one element
        if (aEnd == 1) {
            // Case 1: If the larger array also has one element,
            // simply call MO2()
            if (bEnd == 1) return getMedian(a[0], b[0]);

            // Case 2: If the larger array has odd number of elements,
            // then consider the middle 3 elements of larger array and
            // the only element of smaller array. Take few examples
            // like following
            // a = {9}, b[] = {5, 8, 10, 20, 30} and
            // a[] = {1}, b[] = {5, 8, 10, 20, 30}
            if ((bEnd - aStart) % 2 > 0)
                return getMedian(b[bEnd / 2], getMedian(a[0], b[bEnd / 2 - 1], b[bEnd / 2 + 1]));

            // Case 3: If the larger array has even number of element,
            // then median will be one of the following 3 elements
            // ... The middle two elements of larger array
            // ... The only element of smaller array
            return getMedian(b[bEnd / 2], b[bEnd / 2 - 1], a[0]);
        }

        // If the smaller array has two elements
        else if (aEnd == 2) {
            // Case 4: If the larger array also has two elements,
            // simply call MO4()
            if (bEnd == 2) return getMedian(a[aStart], a[aStart + 1], b[bStart], b[bStart + 1]);

            // Case 5: If the larger array has odd number of elements,
            // then median will be one of the following 3 elements
            // 1. Middle element of larger array
            // 2. Max of first element of smaller array and element
            //    just before the middle in bigger array
            // 3. Min of second element of smaller array and element
            //    just after the middle in bigger array
            //if ((bEnd & 1) == 1)
            if ((bEnd - aStart) % 2 > 0)
                return getMedian(b[bEnd / 2],
                        max(a[0], b[bEnd / 2 - 1]),
                        min(a[1], b[bEnd / 2 + 1])
                );

            // Case 6: If the larger array has even number of elements,
            // then median will be one of the following 4 elements
            // 1) & 2) The middle two elements of larger array
            // 3) Max of first element of smaller array and element
            //    just before the first middle element in bigger array
            // 4. Min of second element of smaller array and element
            //    just after the second middle in bigger array
            return getMedian(b[bEnd / 2],
                    b[bEnd / 2 - 1],
                    max(a[0], b[bEnd / 2 - 2]),
                    min(a[1], b[bEnd / 2 + 1])
            );
        }

        int idxA = (aEnd - 1) / 2;
        int idxB = (bEnd - 1) / 2;

        Out.pln();
        Out.plnRange("a", a, aStart, aEnd - 1, aStart + idxA);
        Out.plnRange("b", b, bStart, bEnd - 1, bStart + idxB);
        Out.pln();

        if (a[aStart + idxA] <= b[bStart + idxB])
            return ver3Median(a, aStart + idxA, aEnd / 2 + 1, b, bStart, bEnd - idxA);
        else
            return ver3Median(a, aStart, aEnd / 2 + 1, b, bStart + idxA, bEnd - idxA);
    }

    public static double ver4(int A[], int B[]) {
        if (A.length > B.length) {
            int[] tmp = A;
            A = B;
            B = tmp;
        }
        return ver4(A, A.length, B, B.length);
    }

    public static double ver4(int a[], int aLen, int b[], int bLen) {
        /* b[0, 1, 2, ..., bLen-1, bLen] */
        /* a[0, 1, 2, ..., aLen-1, aLen] */
        int k = (aLen + bLen + 1) / 2;
        double v = (double) findKth(a, 0, aLen - 1, b, 0, bLen - 1, k);

        if ((aLen + bLen) % 2 == 0) {
            k++;
            double v2 = (double) findKth(a, 0, aLen - 1, b, 0, bLen - 1, k);
            v = (v + v2) / 2;
        }

        return v;
    }

    public static int findKth(int a[], int aStart, int aEnd, int b[], int bStart, int bEnd, int k) {
        if (aStart > aEnd)
            return b[bStart + k - 1];
        if (bStart > bEnd)
            return a[aStart + k - 1];

        final int aMid = (aStart + aEnd) / 2;
        final int bMid = (bStart + bEnd) / 2;
        final int z = (aMid - aStart) + (bMid - bStart) + 1;

        if (a[aMid] <= b[bMid]) {
            if (k <= z) {
                return findKth(a, aStart, aEnd, b, bStart, bMid - 1, k);
            } else {
                return findKth(a, aMid + 1, aEnd, b, bStart, bEnd, k - (aMid - aStart) - 1);
            }
        } else { // a[aMid] > b[bMid]
            if (k <= z) {
                return findKth(a, aStart, aMid - 1, b, bStart, bEnd, k);
            } else {
                return findKth(a, aStart, aEnd, b, bMid + 1, bEnd, k - (bMid - bStart) - 1);
            }
        }
    }

    static float getMedian(int arr[], int end) {
        if (end == 0) return -1;
        if (end % 2 == 0) return (arr[end / 2] + arr[end / 2 - 1]) / 2;
        return arr[end / 2];
    }

    static float getMedian(float a, float b) {
        return (a + b) / 2.0f;
    }

    static float getMedian(int a, int b, int c) {
        return a + b + c - max(a, max(b, c)) - min(a, min(b, c));
    }

    static float getMedian(int a, int b, int c, int d) {
        int max = max(a, max(b, max(c, d)));
        int min = min(a, min(b, min(c, d)));
        return (a + b + c + d - max - min) / 2.0f;
    }


}
