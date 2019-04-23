package com.my.lab3.task1;


import com.my.lab3.task1.files.FileHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    public void start(Stage stage) throws IOException {
        ConcreteObservable o = new ConcreteObservable();

        Gui c = new Gui(o);
        FXMLLoader loader = new FXMLLoader(Gui.class.getResource("gui.fxml"));
        loader.setControllerFactory(type -> {
            if(type == Gui.class) return c;
            else throw new IllegalArgumentException("Unexpected controller type " + type);
        });
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Cli cli = new Cli(o);
        Thread cliThread = new Thread(cli::run);
        cliThread.setDaemon(true);
        cliThread.start();
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
