package com.crossoverjie.niodemo.manyreacts;

import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ThreadPoolExecutor;

public interface HandleState {
    void changeState(HandleState state);

    void progress(StateHandler stateHandler, SocketChannel serverSocketChannel, SelectionKey selectionKey, ThreadPoolExecutor threadPoolExecutor);
}
