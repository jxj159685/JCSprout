package com.crossoverjie.array;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] j = new int[7];
        int[] i = new int[10];
        Arrays.fill(j, 47);
        Arrays.fill(j, 48);
        System.out.println(j);
        System.out.println(Arrays.toString(j));
        int[] k = new int[5];
        Arrays.fill(k, 101);
        System.arraycopy(k, 0, i, 5, k.length);
        System.out.println(Arrays.toString(i));
    }
}
