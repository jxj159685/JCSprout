package com.crossoverjie.innerclass;

public class MultipleImpl {

}

class D {

}


abstract class E {

}

class Z extends D {
    E makeE() {
        return new E() {
        };
    }
}