package com.crossoverjie.innerclass;

public class Impl1 implements Service {

    private Impl1() {
    }

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }

    public static ServiceFactory serviceFactory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Impl1();
        }
    };


}
