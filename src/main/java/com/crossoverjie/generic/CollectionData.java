package com.crossoverjie.generic;

import java.util.ArrayList;

public class CollectionData<T> extends ArrayList<T> {
    private static final long serialVersionUID = -9048226010653108740L;

    public CollectionData(Generator<T> generator, int initialCapacity) {
        for (int i = 0; i < initialCapacity; i++) {
            add(generator.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> generator, int initialCapacity) {
        return new CollectionData<>(generator, initialCapacity);
    }
}
