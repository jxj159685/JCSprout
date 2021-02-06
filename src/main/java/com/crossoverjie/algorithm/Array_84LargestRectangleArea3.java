package com.crossoverjie.algorithm;

public class Array_84LargestRectangleArea3 {
    public static int largestRectangleArea(int[] height) {
        long k = System.nanoTime();
        if (height == null || height.length == 0) {
            return 0;
        }
        //存放左边比它小的下标
        int[] leftLess = new int[height.length];
        //存放右边比它小的下标
        int[] rightLess = new int[height.length];
        rightLess[height.length - 1] = height.length;
        leftLess[0] = -1;

        //计算每个柱子左边比它小的柱子的下标
        for (int i = 1; i < height.length; i++) {
            int p = i - 1;
            while (p >= 0 && height[p] >= height[i]) {
                p = leftLess[p];
            }
            leftLess[i] = p;
        }
        //计算每个柱子右边比它小的柱子的下标
        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < height.length && height[p] >= height[i]) {
                p = rightLess[p];
            }
            rightLess[i] = p;
        }
        int maxArea = 0;
        //以每个柱子的高度为矩形的高，计算矩形的面积。
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (rightLess[i] - leftLess[i] - 1));
        }
        long j = System.nanoTime();
        System.out.println(j - k);
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3, 2, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 32, 1, 5, 6, 2, 3}));
    }
}
