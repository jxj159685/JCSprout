package com.crossoverjie.innerclass;

public class CallBacks {
    public static void main(String[] args) {

    }
}

interface Incrementable {
    void increment();
}


class Callee1 implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        i++;
    }
}

class MyIncrement {
    public void increment() {
        System.out.println("do other!");
    }

    static void f(MyIncrement myIncrement) {
        System.out.println("do nothing!");
        myIncrement.increment();
    }
}

class Caller2 extends MyIncrement {
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i++;
    }

    private class XBx implements Incrementable {

        @Override
        public void increment() {
            Caller2.this.increment();
        }
    }

    Incrementable getRef() {
        return new XBx();
    }

}


class Caller {
    private Incrementable incrementable;

    Caller(Incrementable incrementable) {
        incrementable = incrementable;
    }

    void go() {
        incrementable.increment();
    }
}