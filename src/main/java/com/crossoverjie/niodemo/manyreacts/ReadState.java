package com.crossoverjie.niodemo.manyreacts;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ThreadPoolExecutor;

public class ReadState implements HandleState {
    private SelectionKey sk;

    @Override
    public void changeState(HandleState state) {

    }

    @Override
    public void progress(StateHandler stateHandler, SocketChannel socketChannel, SelectionKey selectionKey, ThreadPoolExecutor threadPoolExecutor) {
        //处理读事件
        this.sk = selectionKey;
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                byteBuffer.clear();
                System.out.println(byteBuffer.position());
                int readNumber = socketChannel.read(byteBuffer);
                System.out.println(readNumber);
                if (0 == readNumber) {
                    break;
                }
                stringBuffer.append(byteBuffer.array());
            }
            //处理业务逻辑
            threadPoolExecutor.execute(new SerHandler(stringBuffer));
            stateHandler.setState(new WriteState());
            socketChannel.write(byteBuffer);
            sk.interestOps(SelectionKey.OP_WRITE); // 通過key改變通道註冊的事件
            sk.selector().wakeup();
            System.out.println(stringBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class SerHandler implements Runnable {

        private String data;

        public SerHandler(StringBuffer stringBuffer) {
            this.data = stringBuffer.toString();
        }

        @Override
        public void run() {
            System.out.println(data);
        }
    }


}
