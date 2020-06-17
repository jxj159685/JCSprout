package com.crossoverjie.design.pattern.mybatis.interceptor;

import com.crossoverjie.design.pattern.mybatis.InterceptorChain;
import com.crossoverjie.design.pattern.mybatis.UpdateServiceImpl;
import com.crossoverjie.design.pattern.mybatis.service.UpdateService;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InterceptorChain interceptorChain = new InterceptorChain();
        interceptorChain.addInterceptor(new PageInterceptor());
        interceptorChain.addInterceptor(new SizeInterceptor());
        interceptorChain.addInterceptor(new PageInterceptor());
        //这个对象已经被包装了好几层代理对象
        UpdateService o = (UpdateService) interceptorChain.pluginAll(new UpdateServiceImpl());
        byte[] $Proxy0s = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{o.getClass()});
        String path = Main.class.getResource("").toString();
//            System.out.println("get the path"+path);
        FileOutputStream fileOutputStream = new FileOutputStream("$Proxy1.class");
        fileOutputStream.write($Proxy0s);
        fileOutputStream.close();
        o.update();
    }
}
