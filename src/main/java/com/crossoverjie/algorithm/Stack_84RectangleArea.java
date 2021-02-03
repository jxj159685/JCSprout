package com.crossoverjie.algorithm;

import java.util.Stack;

public class Stack_84RectangleArea {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> mono_stack = new Stack<Integer>();
        if (mono_stack.empty()) {
            mono_stack.push(-1);
        }
        int anx = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                mono_stack.push(i);
            }
            if (heights[i] >= mono_stack.peek()) {
                mono_stack.push(i);
            }
            // 右边界确定开始计算当前
            if (heights[i] < mono_stack.peek()) {

            }
        }
    }
}
