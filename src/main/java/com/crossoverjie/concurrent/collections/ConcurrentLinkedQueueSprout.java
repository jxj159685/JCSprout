package com.crossoverjie.concurrent.collections;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueSprout {
    public static void main(String[] args) throws InterruptedException {
//        ConcurrentLinkedQueue concurrentLinkedQueue =  new ConcurrentLinkedQueue<String>();
//        new Thread(()->{
//            concurrentLinkedQueue.add("1");
//        }).start();
//        new Thread(()->{
//            concurrentLinkedQueue.add("2");
//        }).start();
        Integer tail = new Integer(2);
        Integer j = new Integer(1);
        Integer k = tail; tail = new Integer(2);
        System.out.println(k == tail);

    }
}
