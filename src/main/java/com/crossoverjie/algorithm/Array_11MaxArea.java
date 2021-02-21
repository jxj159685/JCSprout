package com.crossoverjie.algorithm;

public class Array_11MaxArea {
    public static void main(String[] args) {

    }

    public static int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                area = Math.max(area, Math.min(height[j], height[i]) * (j - i));
            }
        }
        return area;
    }


    public static int maxArea2(int[] height) {
        int area = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return area;
    }
}
