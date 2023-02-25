package com.manela;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void startServer(int port) {
        try (ServerSocket ss = new ServerSocket(port)) {
            while (true) {
                new MultiServerThread(ss.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("IOException");
            System.err.println("Could not listen on port " + port);
            System.exit(-1);
        }
    }
}
