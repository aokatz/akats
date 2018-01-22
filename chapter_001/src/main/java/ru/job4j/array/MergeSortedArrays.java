package ru.job4j.array;

import java.util.Arrays;

/**
 * Слияние отсортированных массивов.
 * @author AKats
 */
public class MergeSortedArrays {
    public static int[] mergeArrays(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, res, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, res, ++i, a.length - aIndex);
                break;
            }
        }
        return res;
    }
}
