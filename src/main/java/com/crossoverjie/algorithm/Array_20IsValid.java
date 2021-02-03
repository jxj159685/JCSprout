package com.crossoverjie.algorithm;

import java.util.LinkedList;
import java.util.Stack;

public class Array_20IsValid {

    public static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for (Character c : s.toCharArray()) {
            if (c.equals('{')) {
                stack.addFirst('}');
            } else if (c.equals('[')) {
                stack.addFirst(']');
            } else if (c.equals('(')) {
                stack.addFirst(')');
            } else {
                if (!stack.removeFirst().equals(c)) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            if (c.equals('{')) {
                stack.add('}');
            } else if (c.equals('[')) {
                stack.add(']');
            } else if (c.equals('(')) {
                stack.add(')');
            } else {
                if (!stack.pop().equals(c)) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("{{[()}}"));
    }
}
