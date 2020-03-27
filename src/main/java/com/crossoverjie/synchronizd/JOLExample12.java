package com.crossoverjie.synchronizd;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class JOLExample12 {
    static List<A> list = new ArrayList<A>();
    public static void main(String[] args) throws Exception {
        Thread.sleep(6000);
        Thread t1 = new Thread() {
            public void run() {
                for (int i=0;i<40;i++){
                    A a = new A();
                    synchronized (a){
                        System.out.println("111111");
                        list.add(a);
                        if (i==18){
                            out.println(ClassLayout.parseInstance(a).toPrintable());
                        }
                    }
                }

            }

        };
        t1.start();
        t1.join();
        out.println("befre t2");
        //偏向
        out.println(ClassLayout.parseInstance(list.get(1)).toPrintable());
        Thread t2 = new Thread() {
            int k=0;
            public void run() {
                for(A a:list){
                   synchronized (a){
                       System.out.println("22222");
                       if (k==25){
                           out.println("t2 ing");
                           //轻量锁
                           out.println(ClassLayout.parseInstance(a).toPrintable());

                       }
                   }
                    k++;
                }

            }
        };
        list.clear();
        t2.start();
    }
}