package com.crossoverjie.concurrent;

import org.apache.tools.ant.Executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchAQS {
    static ExecutorService executorService = Executors.newFixedThreadPool(3);
    final static CountDownLatch countDownLatch = new CountDownLatch(3);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(1);
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println("90");

        executorService.shutdown();
    }
}
