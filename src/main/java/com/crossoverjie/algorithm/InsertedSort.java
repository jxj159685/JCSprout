package com.crossoverjie.algorithm;

import java.util.Arrays;

public class InsertedSort {
    public static void main(String[] args) {
        int[] tes = new int[]{7, 8, 4, 6, 10, 3, 1};
        insertedSort(tes);
        System.out.println(Arrays.toString(tes));
    }

    public static void insertedSort(int[] arr) {
        int len = arr.length;

        for (int i = 1; i < len; i++) {
            //already sorted a[i-1] a[i-2] 右移动
            for (int j = i; j > 0; j--) {
                // 右移动
                if (arr[j] < arr[j - 1]) {
                    SortUtil.swap(j - 1, j, arr);
                }
            }
        }
    }
}
