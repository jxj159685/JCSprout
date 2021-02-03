package com.crossoverjie.algorithm;

/**
 * 求矩形图最大面积
 */
public class Stack_84largestRectangleArea {
    public static int largestRectangleArea(int[] heights) {
        int area = 0; int n = heights.length;
        for(int i = 0; i < n; i++){
            int j = i, h = heights[i], w = 1;
            while (--j >= 0 && heights[j]>=h ){
                w++;
            }
            j = i;
            while (++j < n && heights[j]>=h ){
                w++;
            }
            area = Math.max(area, w * h);
        }
        return area;
    }

    public static void main(String[] args) {
        largestRectangleArea(new int[]{2,1,2});
    }
}
