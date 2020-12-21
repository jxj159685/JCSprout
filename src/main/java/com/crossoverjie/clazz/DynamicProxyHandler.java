package com.crossoverjie.clazz;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {
    private Object realObject;

    public DynamicProxyHandler(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (args != null) {
            for (Object arg : args) {
                System.out.println(arg);
            }
        }
        System.out.println("do something of  myself ");
        return method.invoke(realObject, args);
    }
}
