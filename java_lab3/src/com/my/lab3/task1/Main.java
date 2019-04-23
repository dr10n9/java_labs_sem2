package com.my.lab3.task1;


import com.my.lab3.task1.files.FileHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    public static void main(String[] args) {
        //generate new input
        FileHandler fileHandler = new FileHandler("input.txt");
        try {
            fileHandler.generateFile();
        } catch (IOException e) {
            System.err.println(e.toString());
        }

        launch(args);
    }
}
