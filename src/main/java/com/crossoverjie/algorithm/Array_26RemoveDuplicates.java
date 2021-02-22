package com.crossoverjie.algorithm;

public class Array_26RemoveDuplicates {
    //移除数组中的重复元素
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[slow]) {
                // 因为第一个元素不需要考虑， 所以slow先++
                slow++;
                nums[slow] = nums[i];
            }
        }

        return slow + 1;
    }
}
