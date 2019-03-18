package com.my.lab2.task1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Obs o = new Obs();

        Controller c = new Controller(o);
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource("task1.fxml"));
        loader.setControllerFactory(type -> {
            if(type == Controller.class) return c;
            else throw new IllegalArgumentException("Unexpected controller type " + type);
        });
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        CLI cli = new CLI(o);
        Thread cliThread = new Thread(cli::run);
        cliThread.setDaemon(true);
        cliThread.start();
    }

    public static void main(String [] args) {
        launch(args);
    }
}
