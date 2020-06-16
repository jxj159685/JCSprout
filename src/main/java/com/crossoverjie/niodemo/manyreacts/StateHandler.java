package com.crossoverjie.niodemo.manyreacts;

import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class StateHandler implements Runnable {
    private final SocketChannel ssc;
    private final SelectionKey sk;
    private static final int THREAD_COUNTING = 10;
    private static ThreadPoolExecutor pool = new ThreadPoolExecutor(
            THREAD_COUNTING, THREAD_COUNTING, 10, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>());

    private HandleState state;

    public StateHandler(SocketChannel ssc, SelectionKey selector) {
        this.ssc = ssc;
        this.sk = selector;
        state = new ReadState();
        pool.setMaximumPoolSize(32);
    }

    public void run() {
        state.progress(this, ssc, sk, pool);
    }

    public void closeSocket() {
        try {
            ssc.close();
        } catch (Throwable throwable) {
            System.out.println("关闭连接失败!");
        }
    }

    public void setState(HandleState state) {
        this.state = state;
    }
}
