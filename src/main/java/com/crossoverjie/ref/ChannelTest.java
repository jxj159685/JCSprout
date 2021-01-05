package com.crossoverjie.ref;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {
    static int size = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel fileChannel = new FileOutputStream("love.txt").getChannel();
        fileChannel.write(ByteBuffer.wrap("io".getBytes()));
        fileChannel.close();
        fileChannel = new RandomAccessFile("love.txt", "rw").getChannel();
        fileChannel.position(fileChannel.size());
        fileChannel.write(ByteBuffer.wrap("io2".getBytes()));
        fileChannel.close();
        fileChannel = new FileInputStream("love.txt").getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(size);
        fileChannel.read(allocate);
        //0 <= position <= limit <= capacity
//        allocate.flip();
        allocate.clear();
        while (allocate.hasRemaining()) {
            System.out.println((char) allocate.get());
        }
    }
}
