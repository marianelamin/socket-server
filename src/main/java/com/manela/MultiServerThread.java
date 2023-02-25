package com.manela;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MultiServerThread extends Thread {
    private final Socket socket;

    MultiServerThread(Socket socket) {
        super("MultiServerThread");
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {


            System.out.println("client connected");
            out.println("Welcome!");

            String inputLine, outputLine;

            while ((inputLine = in.readLine()) != null) {
                outputLine = MessagePicker.process(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye."))
                    break;
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
