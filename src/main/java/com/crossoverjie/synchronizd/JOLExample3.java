package com.crossoverjie.synchronizd;
import org.openjdk.jol.info.ClassLayout;

import static java.lang.System.out;

public class JOLExample3 {
   static A a;
    public static void main(String[] args) throws Exception {
//        Thread.sleep(6000);//睡眠5秒以后变成偏向锁
        a= new A();
        //a.hashCode();
        out.println("befor lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());//无锁：偏向锁？
        synchronized (a){//没有锁竞争所以是轻量级锁
            out.println("lock ing");
            out.println(ClassLayout.parseInstance(a).toPrintable());
        }

        out.println("after lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
