package com.crossoverjie.algorithm;

import java.util.TreeMap;

public class Array_215FindKthLargest {
    public static void main(String[] args) {
        System.out.println(findKthLargest(AlgorithUtil.c, 2));
    }

    public static int findKthLargest(int[] nums, int n) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = treeMap.get(nums[i]);
            if (null != count) {
                treeMap.put(nums[i], ++count);
            } else {
                treeMap.put(nums[i], 1);
            }
        }
        for (int c = treeMap.get(treeMap.lastKey()); c < n; c += treeMap.get(treeMap.lastKey())) {
            treeMap.remove(treeMap.lastKey());
        }
        return treeMap.lastKey();
    }


    public static int findKthLargest2(int[] nums, int n) {
        int l = -1;//左侧的元素小于K [0-l]
        int r = nums.length;//右侧的元素小于K [0-l]
        for (int i = 0; i < n; i++) {

        }
        return 0;


    }

    private static void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }
}
