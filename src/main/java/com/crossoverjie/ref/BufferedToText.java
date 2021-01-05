package com.crossoverjie.ref;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class BufferedToText {
    static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel fileChannel = new FileOutputStream("love.txt").getChannel();
        ByteBuffer byteBuffer = ByteBuffer.wrap("like ".getBytes(StandardCharsets.UTF_16BE));
        fileChannel.write(byteBuffer);
        fileChannel.close();
        fileChannel = new FileInputStream("love.txt").getChannel();
        byteBuffer.clear();
        byteBuffer = ByteBuffer.allocate(BSIZE);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        System.out.println(byteBuffer.asCharBuffer());
        System.out.println(System.getProperty("file.encoding"));
    }
}
