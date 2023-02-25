package com.manela.config;

public class SocketSettings {
    private String[] args;
    public int port;

    public SocketSettings(String[] args) {
        this.args = args;
    }

    public boolean validate() {
        if (args.length != 1) {
            System.out.println("Debes colocar host:port");
            return false;
        }
        try {
            this.port = Integer.parseInt(args[0]);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Puerto debe ser un numero");
            return false;
        }
    }
}
