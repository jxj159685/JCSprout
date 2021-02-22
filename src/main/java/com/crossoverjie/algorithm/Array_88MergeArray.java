package com.crossoverjie.algorithm;

public class Array_88MergeArray {
    //合并成一个新的有序数组
    //思路1 直接合并  再排序 不值得学习
    //思路2 双指针，两个数组有序每次比较两个数组的最大值，大的放入nums1的最右边
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int size = m + n - 1;
        while (j >= 0 && i >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[size--] = nums1[i--];
            } else {
                nums1[size--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[size--] = nums2[j--];
        }
    }
}
