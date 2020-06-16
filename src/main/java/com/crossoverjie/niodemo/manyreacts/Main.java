package com.crossoverjie.niodemo.manyreacts;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        RpcReactor rpcReactor = new RpcReactor(1444);
        rpcReactor.run();
    }
}
