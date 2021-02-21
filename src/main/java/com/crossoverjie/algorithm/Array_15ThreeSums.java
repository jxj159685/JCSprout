package com.crossoverjie.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_15ThreeSums {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> re = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            int let = 0 - nums[i];
            if (nums[i] == nums[i + 1]) continue;
            while (j < k) {
                if (nums[j] + nums[k] > let) {
                    k--;
                } else if (nums[j] + nums[k] < let) {
                    j++;
                } else {
                    re.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    k--;
                    j++;
                }
            }
        }
        return re;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
