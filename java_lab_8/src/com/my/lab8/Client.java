package com.my.lab8;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class Client {
    @FXML
    TextField input;
    @FXML
    TextArea messages;

    private Socket socket;
    private BufferedReader in;


    private static final int PORT = 2323;

    public Client() {
        try {
            InetAddress inetAddress = InetAddress.getByName(null);
            socket = new Socket(inetAddress, PORT);
            System.out.println(socket);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Listening again");

                    try {
                        String mes;
                        mes = in.readLine();
//                    messages.setText(mes);
                        System.out.println(mes);
                        pushText(mes);
                    } catch (IOException e) {
                        System.out.println(e.toString());
                    }
                }
            };
            Timer timer = new Timer();
            long delay = 1l;
            long period = 1l;
            timer.schedule(task, delay, period);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    private void pushText(String mes) {
        messages.appendText(mes + "\n");
    }

    @FXML
    private void send() {
        try {
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream()
                            )
                    ), true
            );
            out.println(input.getText());
//            socket.getOutputStream().write(input.getText().getBytes());
//            socket.getOutputStream().flush();
        } catch (IOException e) {

        }
    }

    @FXML
    public void exitApplication(ActionEvent e) {

    }
}
