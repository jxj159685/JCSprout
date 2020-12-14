package com.crossoverjie.basic;

import com.crossoverjie.innerclass.Apple;

public class ApplePile {
    protected class AppleInner implements Apple {
        @Override
        public void red() {
            System.out.println("a");
        }
    }
}
