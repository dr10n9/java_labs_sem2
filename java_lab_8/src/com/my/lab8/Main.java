package com.my.lab8;

import javafx.stage.Stage;

import java.io.*;
import java.net.*;

public class Main {
    private static int PORT = 2323;
    public static void main(String [] args) throws IOException {
        new Thread(new Server()).start();
    }
}
