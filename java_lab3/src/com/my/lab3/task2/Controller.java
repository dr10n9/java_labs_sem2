package com.my.lab3.task2;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {
    private Strings strings;
    private StringBuilder builder = new StringBuilder();

    @FXML
    TextField input;
    @FXML
    TextArea stringsText;
    public Controller() {
        System.out.println("controller constructor");
        strings = new Strings(new ArrayList<>());
    }

    public void add() {
        strings.add(input.getText());
        System.out.println(input.getText());
        builder.append(input.getText() + "\n");
        stringsText.setText(builder.toString());
    }
    public void save() {
        strings.saveToFile("test.dat");
    }
    public void load() {
        strings.readFromFile("test.dat");
        System.out.println(strings.getList().toString());
        builder.setLength(0);
        for(String s: strings.getList()) builder.append(s + "\n");
        stringsText.setText(builder.toString());
    }

}
