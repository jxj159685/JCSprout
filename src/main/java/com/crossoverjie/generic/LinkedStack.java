package com.crossoverjie.generic;

/**
 * 链式结构堆栈
 *
 * @param <T>
 */
public class LinkedStack<T> {

    private Node<T> top = new Node<>();

    private static class Node<U> {
        /**
         * 内容
         */
        U item;
        /**
         * 下一个元素
         */
        private Node<U> next;

        public Node() {
            this.item = null;
            this.next = null;
        }

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        /**
         * 是否是空元素
         */
        public boolean isEnd() {
            return item == null && next == null;
        }
    }

    public void push(T item) {
        if (null == item) {
            return;
        }
        top = new Node<>(item, top);
    }

    public T pop() {
        if (top.isEnd()) {
            return null;
        }
        if (null != top) {
            T x = top.item;
            top = top.next;
            return x;
        } else {
            return null;
        }
    }
}
