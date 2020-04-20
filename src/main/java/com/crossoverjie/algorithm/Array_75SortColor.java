package com.crossoverjie.algorithm;

//频率存放 88 215
//三路快速排序
public class Array_75SortColor {

    public static void main(String[] args) {
        sortColor3Ways(new int[]{0, 2, 2, 1, 0, 1, 1, 2});
    }

    public static void sortColor(int[] nums) {
        //频率
        int[] a = new int[3];
        for (int i = 0; i < nums.length; i++) {
            a[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < a[0]; i++) {
            nums[index++] = a[0];
        }

        for (int i = 0; i < a[1]; i++) {
            nums[index++] = a[1];
        }

        for (int i = 0; i < a[2]; i++) {
            nums[index++] = a[2];
        }

    }


    //三路快排
    public static void sortColor3Ways(int[] nums) {
        //频率、
        int l = -1;//[0-l]都是0 初始时候灭有元素 所以l = -1
        int r = nums.length; //[r-n-1] 没有元素
        for (int i = 0; i < r; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                r--;
                swap(nums, i, r);
            } else {
                l++;
                swap(nums, i, l);
//                if (nums[i] == 1 || nums[i] == 0) {
                i++;
//                }
            }
        }
        System.out.println(1);

    }

    private static void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }
}
