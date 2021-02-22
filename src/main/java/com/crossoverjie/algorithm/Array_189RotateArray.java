package com.crossoverjie.algorithm;

public class Array_189RotateArray {
    public

    static int[]

    rotate(int[] nums, int k) {
        // 思路 所有的元素向右移动
        int size = nums.length;
        for (int i = 0; i < k; i++) {
            int last = nums[size - 1];
            for (int j = size - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = last;
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(rotate(new int[]{2, 3, 4, 5, 6}, 3));
    }

}
