package com.crossoverjie.algorithm;

public class SortUtil {
    public static void swap(int i, int j, int[] arr) {
        int v1 = arr[i];
        arr[i] = arr[j];
        arr[j] = v1;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        Comparable[] aux = new Comparable[a.length];
        int i = lo, j = mid + 1;
        //复制
        for (int k = lo; k < hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k < hi; k++) {
            if (SortUtil.less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[i++];
            }
        }
    }


}
