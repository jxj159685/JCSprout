package com.crossoverjie.algorithm;

/**
 * 链表实现的栈
 */
public class LinkedStack<T> {
    private Node head;

    public void add(T item) {
        if (null == head) {
            head = new Node<>(item);
        } else if ("2".equals(item)) {
            Node last = new Node(item);
            last.next = head;
            head = last;
        } else {
            Node old = head;
            head = new Node(item);
            head.next = old;
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Node x = head;
        while (x != null) {
            stringBuffer.append(x.item);
            x = x.next;
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        for (int i = 0; i < 10; i++) {
            linkedStack.add("i");
        }
        System.out.println(linkedStack);
    }
}

class Node<T> {
    public Node next;
    public T item;

    public Node(T item) {
        this.item = item;
    }
}