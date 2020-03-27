package com.crossoverjie.concurrent.collections;

import ch.qos.logback.core.util.ExecutorServiceUtil;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;

/**
 * @return
 * @param
 * @Description SynchronousQueue实战
 * @Date 2020/3/16
 * @Created by ShareDream.J
 */
public class SynchronousQueueSprout {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new SynchronousQueue(true);
        new Thread(() -> {
            try {
                while (true){
                    //子线程先执行 之后进入等待 然线程对象放入队列里 进入睡眠
                    //主线程put完之后，t != tail || m == null || h != head节点不一样，说明有别的线程等待中continue
                    //拿到head节点的next节点，将put内容cas交换放入next节点的item对象中，然后替换head节点为next节点
                    //next升级为head节点之后唤醒节点内保存的waiter对象，继续执行线程，此时唤醒的线程发现item的值不为null
                    //然后获取item的值进行返回
                    System.out.println(blockingQueue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(5000);
        blockingQueue.put("1");
//        blockingQueue.put("3");
//        blockingQueue.put("4");
//        blockingQueue.put("5");
        ThreadFactory build = new ThreadFactoryBuilder().build();
        build.newThread(() ->{
            System.out.println();
        }).start();
    }

}
