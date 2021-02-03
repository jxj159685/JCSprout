package com.crossoverjie.algorithm;

import java.util.Arrays;

public class Array_284MoveZore {
    public static int[] moveZeroes(int[] nums) {
        int j = 0;
        int mod = nums[0] == 0 ? 0 : 1;
        if (mod == 0) {
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (num != 0) {
                    SortUtil.swap(i, j, nums);
                    j++;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (num == 0) {
                    if (j == 0) {
                        j = i;
                    }
                } else {
                    if (j > 0) {
                        SortUtil.swap(i, j, nums);
                        j++;
                    }
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[]{0, 0, 0, 0})));
    }
}
