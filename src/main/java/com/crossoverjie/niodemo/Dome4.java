package com.crossoverjie.niodemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Dome4 {
    public static void main(String[] args) throws Exception {
        //写进文件
        FileOutputStream fileOutputStream = new FileOutputStream("dome4write.txt");
        //读取文件
        FileInputStream fileInputStream = new FileInputStream("dome4read.txt");

        FileChannel channelRead = fileInputStream.getChannel();
        FileChannel channelWrite = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        while (true) {
            byteBuffer.clear();
            System.out.println(byteBuffer.position());
            int readNumber = channelRead.read(byteBuffer);
            System.out.println(readNumber);
            if (-1 == readNumber) {
                break;
            }
            System.out.println(new String(byteBuffer.array(), "utf-8"));
//            byteBuffer.flip();
//            channelWrite.write(byteBuffer);
        }
        fileOutputStream.close();
        fileInputStream.close();
    }
}
