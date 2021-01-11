package com.crossoverjie.ref;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class LargeMapper {
    static int length = 1278;

    public static void main(String[] args) throws IOException {
        MappedByteBuffer mappedByteBuffer = new RandomAccessFile("love.txt", "rw").getChannel().
                map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            mappedByteBuffer.put((byte) 'x');
        }
//        for (int i = 0; i < length; i++) {
//            System.out.println((char) mappedByteBuffer.get(i));
//        }

    }
}
