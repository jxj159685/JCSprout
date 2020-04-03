package com.crossoverjie.concurrent.collections;

import com.google.common.collect.Lists;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.List;

public class GC {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1; i++) {
            changeOb();
        }
    }

    private static void changeOb() {
        List<Object> objects = Lists.newArrayList();
        for (int i = 0; i < 1000000; i++) {
            objects.add(1);
        }

        if (objects.size() > 0){
            doSomething(objects);
        }
        Runtime runtime = Runtime.getRuntime();
        //248831624 啥都不加
        //248831576 clear
        //248831448 null
        System.out.println(runtime.freeMemory());
    }

    private static void doSomething(List<Object> objects) {
        objects.clear();
//        objects = null;
//        Runtime.getRuntime().gc();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
