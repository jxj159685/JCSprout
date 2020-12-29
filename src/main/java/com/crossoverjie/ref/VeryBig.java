package com.crossoverjie.ref;

public class VeryBig {
    private static final int SIZE = 1000;
    private long[] la = new long[SIZE];
    private String ident;

    public VeryBig(String ident) {
        this.ident = ident;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize");
    }
}
