package com.manela;

public class MessagePicker {

    static String process(String in) {
        System.out.println("client: " + in);

        if (in.startsWith("200"))
            return "210" + in;
        if ("Bye.".equalsIgnoreCase(in))
            return in;

        return "I say, " + in;

    }
}
