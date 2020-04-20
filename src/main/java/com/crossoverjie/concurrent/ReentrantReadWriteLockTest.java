package com.crossoverjie.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

        Thread thread = new Thread("T1"){
            @Override
            public void run() {
                lock.readLock().lock();
                System.out.println(2);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.readLock().unlock();
            }
        };

        Thread thread2 = new Thread("T2"){
            @Override
            public void run() {
                lock.readLock().lock();
                System.out.println(3);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.readLock().unlock();
            }
        };

        Thread thread3 = new Thread("T2"){
            @Override
            public void run() {
                lock.readLock().lock();
                System.out.println(3);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.readLock().unlock();
            }
        };

        thread.start();
        thread2.start();
        thread3.start();


    }
}
