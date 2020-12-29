package com.crossoverjie.generic;

import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionDataTest {
    public static void main(String[] args) {
        CollectionData<Coffee> coffees = CollectionData.list(new CoffeeGenerator(10), 10);
        Set<Coffee> set = new LinkedHashSet<>(new CollectionData<>(new CoffeeGenerator(10), 10));
//        set.addAll(CollectionData.list(new CoffeeGenerator(10), 10));
        System.out.println(set);
    }
}
