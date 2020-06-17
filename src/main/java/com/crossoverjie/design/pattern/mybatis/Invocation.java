package com.crossoverjie.design.pattern.mybatis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/***
 * 功能描述 对象传递媒介
 * @Author ShareDream.J
 * @Date 2020/6/16 10:42
 * @CopyRight 杭州十二章纹文化传播有限公司 @2015-2022
 *
 */
public class Invocation {
    private Object[] args;
    private Method method;
    /**
     * 目标对象可能是个代理对象也有可能是源对象
     */
    private Object target;

    public Invocation(Object[] args, Method method, Object target) {
        this.args = args;
        this.method = method;
        this.target = target;
    }

    public Object getTarget() {
        return this.target;
    }

    public Method getMethod() {
        return this.method;
    }

    public Object[] getArgs() {
        return this.args;
    }


    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return this.method.invoke(this.target, this.args);
    }

}
