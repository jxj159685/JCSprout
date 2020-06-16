package com.crossoverjie.niodemo.manyreacts;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class AcceptHandler implements Runnable {

    private final ServerSocketChannel ssc;
    private final Selector selector;

    public AcceptHandler(Selector selector, ServerSocketChannel ssc) {
        this.ssc = ssc;
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            SocketChannel sc = ssc.accept();
            if (null != sc) {
                sc.configureBlocking(false);
                SelectionKey sk = sc.register(selector, SelectionKey.OP_READ);
                //不要让select阻塞 立即返回
                selector.wakeup();
                sk.attach(new StateHandler(sc, sk));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
