package com.crossoverjie.niodemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 只读buffer
 */
public class Dome7 {
    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer=ByteBuffer.allocate(10);
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte)i);
        }
        ByteBuffer byteBuffer1 = byteBuffer.asReadOnlyBuffer();
        System.out.println(byteBuffer.getClass());
        System.out.println(byteBuffer1.getClass());
        byteBuffer1.flip();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer1.position());
        for (int i = 0; i < byteBuffer1.capacity(); i++) {
            System.out.println(byteBuffer1.get());
        }
        //不能写
        FileInputStream fileInputStream = new FileInputStream("dome4read.txt");

        FileChannel channelRead = fileInputStream.getChannel();

        channelRead.write(byteBuffer1);
        byteBuffer1.position(2);

    }
}
