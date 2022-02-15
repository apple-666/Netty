package com.apple.netty.dubborpc.provicder;

import com.apple.netty.dubborpc.netty.NettyServer;

/**
 * @Author Double_apple
 * @Date 2022/2/15 11:31
 * @Version 1.0
 */
public class ServerBootstrap {
    public static void main(String[] args) {
        NettyServer.startServer("127.0.0.1",7000);
    }
}
