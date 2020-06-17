package com.crossoverjie.design.pattern.mybatis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class InterceptorChain {
    private final List<Interceptor> interceptors = new ArrayList();

    public InterceptorChain() {
    }

    public Object pluginAll(Object target) {
        Interceptor interceptor;
        for (Iterator var2 = this.interceptors.iterator(); var2.hasNext(); target = interceptor.plugin(target)) {
            interceptor = (Interceptor) var2.next();
        }
        return target;
    }

    public void addInterceptor(Interceptor interceptor) {
        this.interceptors.add(interceptor);
    }

    public List<Interceptor> getInterceptors() {
        return Collections.unmodifiableList(this.interceptors);
    }
}
