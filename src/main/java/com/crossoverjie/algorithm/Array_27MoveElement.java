package com.crossoverjie.algorithm;

//        给定 nums = [2,2,3,3,1], val = 3,
//        函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
//        你不需要考虑数组中超出新长度后面的元素。
public class Array_27MoveElement {
    public static void main(String[] args) {
        int i = removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        System.out.println(i);
    }

    public static int removeElement(int[] nums, int val) {
        int k = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                swap(nums, i, k);
                k--;
            }
        }
        return k + 1;
    }

    private static void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }
}
