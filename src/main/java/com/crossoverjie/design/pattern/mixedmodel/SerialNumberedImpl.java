package com.crossoverjie.design.pattern.mixedmodel;

public class SerialNumberedImpl implements SerialNumbered {
    private static long count = 0;
    private final long serialNumber = count++;

    @Override
    public long getSerialNumbered() {
        return serialNumber;
    }
}
