package com.crossoverjie.algorithm;

import java.util.Arrays;

public class SelectedSort {
    public static void main(String[] args) {
        int[] tes = new int[]{7, 8, 4, 6, 10, 3, 1};
        selectSort(tes);
        System.out.println(Arrays.toString(tes));
    }

    public static void selectSort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            SortUtil.swap(i, min, arr);
        }
    }
}
