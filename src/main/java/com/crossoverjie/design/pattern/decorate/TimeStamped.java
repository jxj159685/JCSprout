package com.crossoverjie.design.pattern.decorate;

import java.util.Date;

public class TimeStamped extends Decorate {
    private final long time;

    protected Baisc baisc;

    public TimeStamped(Baisc val) {
        super(val);
        time = new Date().getTime();
    }

    public long getTime() {
        return time;
    }


    public static void main(String[] args) {
        TimeStamped timeStamped = new TimeStamped(new Decorate(new Baisc()));
        System.out.println(timeStamped.getTime());
    }
}
