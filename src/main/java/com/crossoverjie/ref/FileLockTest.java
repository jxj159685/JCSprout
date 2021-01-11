package com.crossoverjie.ref;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLockTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fileOutputStream = new FileOutputStream("love.txt");
        FileLock fileLock = fileOutputStream.getChannel().tryLock();
        if (fileLock != null) {
            System.out.println("Locked file");
            TimeUnit.SECONDS.sleep(25);
            fileLock.release();
            System.out.println("Release lOCK");
        }
        fileOutputStream.close();
    }
}
