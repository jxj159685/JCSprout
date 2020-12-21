package com.crossoverjie.clazz;

import java.lang.reflect.Proxy;

public class DynamicClient {

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consume(realObject);
        consume((Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(realObject)));
    }

    private static void consume(Interface realObject) {
        realObject.doOther();
        realObject.doSomething();
    }
}
