package com.my.lab2.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller implements Observer {
    @FXML
    TextField strings;
    @FXML
    TextArea resultStrings;

    private Obs obs;

    public Controller(Obs obs) {
        this.obs = obs;
        this.obs.addObserver(this);
    }

    public void checkStrings() {
        String input = strings.getText();
        TextContainer tc = new TextContainer(input);
        List<String> listOfWords = tc.getUniqueWhereFirstEqualsLast();
        StringBuilder resultingString = new StringBuilder();
        for(String word : listOfWords){
            resultingString.append(word).append(" ");
        }
        obs.setResult(new ArrayList(listOfWords));
    }

    public void clear() {
        resultStrings.clear();
    }

    @Override
    public void update(Observable o, Object obj) {
        if(o == obs) {
            resultStrings.setText(obs.getResult().toString());
        }
    }
}
