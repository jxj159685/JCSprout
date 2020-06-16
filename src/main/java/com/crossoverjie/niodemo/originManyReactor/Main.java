package com.crossoverjie.niodemo.originManyReactor;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            TCPReactor reactor = new TCPReactor(1444);
//                new Thread(reactor).start();
            reactor.run();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}