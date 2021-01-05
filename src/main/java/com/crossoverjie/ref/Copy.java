package com.crossoverjie.ref;

import java.io.*;

public class Copy {
    public static void main(String[] args) throws IOException {
        File source = new File("./love.txt");
        File copy = new File("./copy.txt");
        if (source.exists()) {
            FileInputStream fileInputStream = new FileInputStream(source);
            copy.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(copy);
            byte[] bytes = new byte[1024];
            int len = bytes.length;
            while ((len = fileInputStream.read(bytes, 0, len)) > 0) {
                fileOutputStream.write(bytes);
                fileOutputStream.flush();
            }
            System.out.println("copy finished");
            fileInputStream.close();

            fileOutputStream.close();
        } else {
            source.createNewFile();
            FileWriter fileWriter = new FileWriter(source);
            String s = new String(" I love Java");
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                fileWriter.write(chars, 0, chars.length);
            }
            fileWriter.close();
        }

    }
}
