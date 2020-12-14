package com.crossoverjie.datatype;

import java.util.ArrayList;
import java.util.List;

public class CharTest {
    public static void main(String[] args) {
        char c = 0x21f;
        float f = 1.39E-43f;
        System.out.println(c);
        System.out.println(Math.E);
        System.out.println(f);
        int z = 0x01;
        int y = 0x11;
        int k = 11;
        float f1 = 1.3434344f;
        System.out.println(Integer.toBinaryString(z));
        System.out.println(Integer.toBinaryString(y));
        System.out.println(Integer.toBinaryString(z ^ y));
        System.out.println(Integer.toBinaryString(-0));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(f1 * k);
        float o12 = 1.2f;
        float o1 = 1f;
        System.out.println(o12 - o1);
        List<Integer> arrays = new ArrayList<>();
        arrays.add(1);
        for (Integer a : arrays) {
            System.out.println(a);
        }

        //11111111111111111111111111111110
        //00000000000000000000000000000010
    }
}
