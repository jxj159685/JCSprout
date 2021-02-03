package com.crossoverjie.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeperMain;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper("", 12, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getPath());
            }
        });
    }
}
