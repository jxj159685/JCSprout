package com.crossoverjie.niodemo.originManyReactor;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ThreadPoolExecutor;

public class WorkState implements HandlerState {

    public WorkState() {
    }

    public void changeState(TCPHandler h) {
        // TODO Auto-generated method stub
        h.setState(new WriteState());
    }

    public void handle(TCPHandler h, SelectionKey sk, SocketChannel sc,
                       ThreadPoolExecutor pool) throws IOException {
        // TODO Auto-generated method stub

    }
}