package com.crossoverjie.ref;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLockTest2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fileOutputStream = new FileOutputStream("love.txt");
        FileLock fileLock = fileOutputStream.getChannel().tryLock();
        while (fileLock == null) {
            System.out.println("could not locked file");
            TimeUnit.SECONDS.sleep(1);
            fileLock = fileOutputStream.getChannel().tryLock();
        }
        if (fileLock != null) {
            System.out.println("Locked file");
            TimeUnit.SECONDS.sleep(1);
            fileLock.release();
            System.out.println("Release lOCK");
        } else {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("could not  locked");
        }
        fileOutputStream.close();
    }
}
