package com.crossoverjie.algorithm;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] tes = new int[]{7, 8, 4, 6, 10, 3, 1, 15, 9, 6};
        quickSort(tes, 0, tes.length - 1);
        System.out.println(Arrays.toString(tes));
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = part(arr, lo, hi);
        quickSort(arr, lo, j - 1);
        quickSort(arr, j + 1, hi);

    }

    private static int part(int[] arr, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = arr[lo];
        while (true) {
            while (SortUtil.less(arr[++i], v)) {
                if (i == hi) break;
            }
            while (SortUtil.less(v, arr[--j])) {
                if (j == lo) break;
            }
            if (i >= j) {
                break;
            }
            SortUtil.swap(i, j, arr);
        }
        SortUtil.swap(lo, j, arr);
        return j;
    }

}
