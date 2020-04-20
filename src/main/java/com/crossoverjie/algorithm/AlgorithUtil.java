package com.crossoverjie.algorithm;

public class AlgorithUtil {

    public static final int[] a = new int[]{1, 2, 0, 0, 3, 4, 10, 8, 9, 7, 5, 4, 2, 9, 4};

    public static final int[] b = new int[]{1, 2, 0, 0, 1, 1, 2, 0};

    public static final int[] c = new int[]{-1, -1};

    /**
     * @return void
     * @Description 交换元素
     * @Date 2020/4/16
     * @Created by ShareDream.J
     */
    private static void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }
}
