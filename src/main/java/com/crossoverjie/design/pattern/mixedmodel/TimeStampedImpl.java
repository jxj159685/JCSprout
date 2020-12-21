package com.crossoverjie.design.pattern.mixedmodel;

import java.util.Date;

public class TimeStampedImpl implements TimeStamped {
    private final long time;

    public TimeStampedImpl() {
        this.time = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return time;
    }
}
