package com.my.lab8;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class SocketProcessor implements Runnable{
    private Socket s;
    private Server server;
    private InputStream is;
    private OutputStream os;

    public SocketProcessor(Socket s, Server server) throws Throwable{
        this.s = s;
        this.server = server;
        is = s.getInputStream();
        os = s.getOutputStream();
    }

    public void run() {
        try {
            System.out.println("Processing new socket: " + s);
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                while (true) {
                    String str = in.readLine();
                    if (str.equals("END")) break;
                    System.out.println(s.toString() + ": " + str);
                    broadcast(s.toString() + ": " + str);
//                    System.out.println(str);
                }
            } catch (IOException e) {}
        } catch (Throwable t) {} finally {
            try {
                s.close();
            } catch (Throwable t) {}
        }
    }

    private void broadcast(String message) {
        for(Socket s: server.getSockets()) {
            if(!s.isClosed()) {
                try {
                    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())), true);
                    out.println(message);
                } catch (IOException e) {
                    System.err.println(e.toString());
                }
            }
        }
    }
}
