package com.crossoverjie.niodemo.manyreacts;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 反应堆
 */
public class RpcReactor {

    private final ServerSocketChannel ssc;
    private final Selector selector;

    public RpcReactor(int port) throws IOException {
        this.ssc = ServerSocketChannel.open();
        this.selector = Selector.open();
        InetSocketAddress address = new InetSocketAddress(port);
        ssc.socket().bind(address);
        ssc.configureBlocking(false);
        //注册连接事件
        SelectionKey register = ssc.register(selector, SelectionKey.OP_ACCEPT);
        register.attach(new AcceptHandler(selector, ssc));
    }

    public void run() throws IOException {
        while (true) {
            //查询是否有自己喜欢的事件
            if (selector.select() == 0) {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()) {
                handle((SelectionKey) keyIterator.next());
                keyIterator.remove();
            }
        }
    }

    private void handle(SelectionKey next) {
        Runnable attachment = (Runnable) next.attachment();
        attachment.run();
    }
}
