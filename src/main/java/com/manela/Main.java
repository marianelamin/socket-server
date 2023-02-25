package com.manela;

import com.manela.config.SocketSettings;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        SocketSettings config = new SocketSettings(args);
        if (!config.validate()) System.exit(-1);

        Server.startServer(config.port);
    }
}