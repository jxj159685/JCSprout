package com.crossoverjie.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Stack_84RectangleArea {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] heightNew = new int[n+2];
        System.arraycopy(heights,0, heightNew, 1, heights.length);
        Deque<Integer> mono_stack = new ArrayDeque<>();
        int anx = 0;
        for (int i = 0; i < heightNew.length; i++) {
            if (i == 0) {
                mono_stack.push(i);
                continue;
            }
            // 右边界确定开始计算当前
            while (!mono_stack.isEmpty() && heightNew[i] < heightNew[mono_stack.peek()]) {
                anx = Math.max(anx, fun(mono_stack,heightNew[mono_stack.pop()],i));
            }
            mono_stack.push(i);
        }
        return anx;
    }

    private static int fun(Deque<Integer>mono_stack, Integer pop, int i) {
        return pop * (i - mono_stack.peek() - 1);
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{6,7,5,2,4,5,9,3}));
    }
}
