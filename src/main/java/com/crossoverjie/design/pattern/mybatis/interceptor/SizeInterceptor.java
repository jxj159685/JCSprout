package com.crossoverjie.design.pattern.mybatis.interceptor;

import com.crossoverjie.design.pattern.mybatis.Interceptor;
import com.crossoverjie.design.pattern.mybatis.Invocation;
import com.crossoverjie.design.pattern.mybatis.Plugin;
import com.crossoverjie.design.pattern.mybatis.service.UpdateService;

public class SizeInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation var1) throws Throwable {
        System.out.println("设计大小");
        var1.proceed();
        System.out.println("设计大小后");
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return target instanceof UpdateService ? Plugin.wrap(target, this) : target;
    }
}
