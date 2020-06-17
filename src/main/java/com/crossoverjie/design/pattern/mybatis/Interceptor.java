package com.crossoverjie.design.pattern.mybatis;

public interface Interceptor {
    Object intercept(Invocation var1) throws Throwable;

    Object plugin(Object var1);

//    void setProperties(Properties var1);
}
