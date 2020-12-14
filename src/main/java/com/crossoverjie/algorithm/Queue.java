package com.crossoverjie.algorithm;

public class Queue {
    //最早进入的元素
    private Node first;
    //最近进入的元素
    private Node last;
    private int N = 0;

    private void addEle(Item ele) {
        Node old = last;
        last = new Node();
        last.item = ele;
        if (isEmpty()) {
            first = last;
        } else {
            old.next = last;
        }
        N++;
    }

    class Node {
        Item item;
        Node next;
    }

    static class Item {

    }

    private boolean isEmpty() {
        return N == 0;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int i = 0; i < 10; i++) {
            queue.addEle(new Item());
        }
        System.out.println(queue.N);
    }
}
