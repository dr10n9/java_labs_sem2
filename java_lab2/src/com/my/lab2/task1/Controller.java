package com.my.lab2.task1;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller extends Observer {
    @FXML
    TextField numbers;
    @FXML
    TextArea luckyNumbers;

    Obs obs;

    public Controller(Obs o) {
        obs = o;
        obs.registerObserver(this);
    }

    public void getLucky() {
        String [] input = numbers.getText().split(" ");
        Numbers n = new Numbers();
        for(String item : input) {
            try {
                n.add(Integer.parseInt(item));
            } catch (Exception e) {
                clear();
                this.luckyNumbers.setText(e.toString());
            }
        }
        List<Integer> l = n.getLuckyNumbers();
        obs.setLuckyNumbers(l);
//        luckyNumbers.setText(l.toString());
    }

    public void clear() {
        luckyNumbers.clear();
    }

    @Override
    public void update(List<Integer> numbers) {
        luckyNumbers.setText(numbers.toString());
    }
}

