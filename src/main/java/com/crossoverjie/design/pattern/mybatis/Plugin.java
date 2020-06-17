package com.crossoverjie.design.pattern.mybatis;

import com.crossoverjie.design.pattern.mybatis.service.UpdateService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;

public class Plugin implements InvocationHandler {
    private final Object target;
    private final Interceptor interceptor;
    private volatile boolean IS_PROXY;

    private Plugin(Object target, Interceptor interceptor, boolean isProxy) {
        this.target = target;
        this.interceptor = interceptor;
        this.IS_PROXY = isProxy;
    }

    public static Object wrap(Object target, Interceptor interceptor) {
        Class<?> type = target.getClass();
        Class<?>[] interfaces = getAllInterfaces(type);
        return Proxy.newProxyInstance(type.getClassLoader(), interfaces, new Plugin(target, interceptor, true));
    }

    private static Class<?>[] getAllInterfaces(Class<?> type) {
        HashSet interfaces;
        for (interfaces = new HashSet(); type != null; type = type.getSuperclass()) {
            Class[] var3 = type.getInterfaces();
            int var4 = var3.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                Class<?> c = var3[var5];
                if (c == UpdateService.class) {
                    interfaces.add(c);
                }
            }
        }
        return (Class[]) interfaces.toArray(new Class[interfaces.size()]);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            return IS_PROXY ? this.interceptor.intercept(new Invocation(args, method, this.target)) : method.invoke(this.target, args);
        } catch (Exception var5) {
            throw new RuntimeException("Plugin invoke error{}", var5);
        }
    }

}
