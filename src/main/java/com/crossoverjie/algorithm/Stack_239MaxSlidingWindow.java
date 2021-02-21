package com.crossoverjie.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Stack_239MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<Integer>();

        int n = nums.length;
        int l = n - k + 1;
        int[] ans = new int[l];
        for (int i = 0; i < n; i++) {
            if (deque.isEmpty()) {
                deque.add(nums[i]);
                continue;
            }
            if (k == 1) {
                deque.add(nums[i]);
                continue;
            }
            if (i < k) {
                while (!deque.isEmpty() && nums[i] > deque.peek()) {
                    deque.pop();
                    deque.add(nums[i]);
                }
            } else {
                for (int j = i - k + 1; j < i + 1; j++) {
                    if (j == i - k + 1) {
                        deque.add(nums[j]);
                        continue;
                    } else {
                        if (nums[j] > deque.getLast()) {
                            deque.removeLast();
                            deque.add(nums[j]);
                        }
                    }
                }

            }
        }
        for (int i = 0; i < l; i++) {
            ans[i] = deque.getFirst();
            deque.removeFirst();
        }
        return ans;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return nums;
        }
        int[] arr = new int[len - k + 1];
        int arr_index = 0;
        if (k == 1) {
            return nums;
        }
        //我们需要维护一个单调递增的双向队列
        Deque<Integer> deque = new LinkedList<>();
        //先将第一个窗口的值按照规则入队
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.offerLast(nums[i]);
        }
        //存到数组里，队头元素
        arr[arr_index++] = deque.peekFirst();
        //移动窗口
        for (int j = k; j < len; j++) {
            // //对应咱们的红色情况，则是窗口的前一个元素等于队头元素
//            if (nums[j - k] == deque.peekFirst()) {
//                deque.removeFirst();
//            }

            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            deque.offerLast(nums[j]);
            if (deque.size() == k) {
                deque.removeFirst();
            }
            arr[arr_index++] = deque.peekFirst();
        }
        return arr;
    }


    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }
}
