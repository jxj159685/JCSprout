package com.crossoverjie.algorithm;

import java.util.Iterator;

/**
 * 固定容量的string容器
 */
public class FixedCapacityStackOfStrings implements Iterable {
    public FixedCapacityStackOfStrings(int size) {
        this.str = new String[size];
    }

    private String[] str;
    private static int N;

    public void add(String item) {
        str[N++] = item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public String pop() {
        return str[--N];
    }

    public int size() {
        return N;
    }


    @Override
    public Iterator iterator() {
        return new StrIterator();
    }

    private class StrIterator implements Iterator {
        @Override
        public boolean hasNext() {
            return N > 0;
        }

        @Override
        public Object next() {
            return str[--N];
        }
    }
}

