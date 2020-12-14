package com.crossoverjie.innerclass;

public class Impl2 implements Service {

    public Impl2() {
    }

    @Override
    public void method1() {
        System.out.println("asa");
    }

    @Override
    public void method2() {

    }

    public static ServiceFactory serviceFactory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Impl2();
        }
    };

    public static void main(String[] args) {
        Impl2.serviceFactory.getService().method1();
    }

}
