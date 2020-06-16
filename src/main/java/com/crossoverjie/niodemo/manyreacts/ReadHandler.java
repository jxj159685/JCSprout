package com.crossoverjie.niodemo.manyreacts;

import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class ReadHandler extends DecNioHandler implements Runnable {
    private final ServerSocketChannel ssc;
    private final Selector selector;

    public ReadHandler(ServerSocketChannel ssc, Selector selector) {
        this.selector = selector;
        this.ssc = ssc;
    }

    HandleState handleState;

    @Override
    public void run() {

    }
}
