package com.crossoverjie.algorithm;

import java.util.Stack;

public class List_206ReverseList {
    public static ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        pushStack(stack, head);
        ListNode newl = null;
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            if (newl == null) {
                newl = new ListNode(stack.pop(), null);
            } else {
                getNext(newl).next = new ListNode(stack.pop(), null);
            }
        }
        return newl;
    }

    // 递归方式
    public static ListNode reverseList2(ListNode head) {
        // 1. 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        // 2. 传递
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        // 3. 回归
        return p;
    }

    // 迭代方式
    public static ListNode reverseList3(ListNode head) {
        ListNode pred = null;
        ListNode curd = head;
        while (curd != null) {
            ListNode next = curd.next;
            curd.next = pred;
            pred = curd;
            curd = next;
        }
        return pred;
    }

    private static ListNode getNext(ListNode newl) {
        if (newl.next != null) {
            return getNext(newl.next);
        } else {
            return newl;
        }
    }

    private static void pushStack(Stack<Integer> stack, ListNode head) {
        if (null != head) {
            stack.push(head.val);
            pushStack(stack, head.next);
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseList3(new ListNode(2, new ListNode(3, new ListNode(4, new ListNode())))));
    }


}
