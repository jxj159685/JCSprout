package com.crossoverjie.algorithm;

import java.util.TreeSet;

//找出第三大的数值 有序去重  TreeSet
//三个变量存储
public class Array_414ThirdMax {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{3, 2, 2}));
    }

    public static int thirdMax(int[] nums) {
        //有序的set
        TreeSet<Integer> treenum = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            treenum.add(nums[i]);
        }
        if (treenum.size() > 3) {
            for (int i = 0; i < 2; i++) {
                treenum.remove(treenum.last());
            }
            return treenum.last();
        } else {
            return treenum.last();
        }
    }
}
