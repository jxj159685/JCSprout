package com.crossoverjie.niodemo.manyreacts;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ThreadPoolExecutor;

public class WriteState implements HandleState {

    @Override
    public void changeState(HandleState state) {

    }

    @Override
    public void progress(StateHandler h, SocketChannel sc, SelectionKey sk, ThreadPoolExecutor threadPoolExecutor) {
        String str = "Your message has sent to "
                + sc.socket().getLocalSocketAddress().toString() + "\r\n";
        ByteBuffer buf = ByteBuffer.wrap(str.getBytes()); // wrap自動把buf的position設為0，所以不需要再flip()

        while (buf.hasRemaining()) {
            try {
                sc.write(buf); // 回傳給client回應字符串，發送buf的position位置 到limit位置為止之間的內容
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        h.setState(new ReadState()); // 改變狀態(SENDING->READING)
        sk.interestOps(SelectionKey.OP_READ); // 通過key改變通道註冊的事件
        sk.selector().wakeup(); // 使一個阻塞住的selector操作立即返回
    }
}
