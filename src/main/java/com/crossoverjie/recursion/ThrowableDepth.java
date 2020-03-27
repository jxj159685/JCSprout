package com.crossoverjie.recursion;

import java.nio.channels.AcceptPendingException;
/**
 * @return
 * @param
 * @Description 子父疏远程度
 * @Date 2020/3/20
 * @Created by ShareDream.J
 */
public class ThrowableDepth {
    public static void main(String[] args) {
        System.out.println(getDepth(Exception.class, 0));
    }

    private  static  int getDepth(Class<?> exceptionClass, int depth) {
        if (exceptionClass.getName().contains("acs")) {
            return depth;
        } else {
            return exceptionClass == Throwable.class ? depth : getDepth(exceptionClass.getSuperclass(), depth + 1);
        }
    }
}
