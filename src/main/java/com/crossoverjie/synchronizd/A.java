package com.crossoverjie.synchronizd;

public class A {
    int i=0;
   // boolean flag =false;
    public synchronized void parse(){
        i++;
        JOLExample6.countDownLatch.countDown();
    }
}
