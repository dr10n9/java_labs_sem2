package com.my.lab8;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server implements Runnable {
    private static int PORT = 2323;
    private ArrayList<Socket> sockets = new ArrayList<>();

    private void processSocket(Socket s) throws Throwable{
        sockets.add(s);
        new Thread(new SocketProcessor(s, this)).start();
    }

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while(true) {
                try {
                    processSocket(serverSocket.accept());
                } catch (Throwable t) {
                    System.out.println(t.toString());
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public ArrayList<Socket> getSockets() {
        return sockets;
    }
}
