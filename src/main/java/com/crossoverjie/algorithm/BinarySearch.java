package com.crossoverjie.algorithm;

/**
 * 二分搜索
 * 递归法和赋值法
 */
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println((1 + 2 + "3"));
    }

    private static int search(int a, int[] ints) {
        int lo = 0;
        int hi = ints.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (a < ints[mid]) {
                hi = mid - 1;
            } else if (a > ints[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static int search2(int a, int lo, int hi, int[] ints) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;//会导致溢出 用减法
            if (a < ints[mid]) {
                return search2(a, lo, mid - 1, ints);
            } else if (a > ints[mid]) {
                return search2(a, lo, mid - 1, ints);
            } else {
                return mid;
            }
        }
        return -1;
    }

}
