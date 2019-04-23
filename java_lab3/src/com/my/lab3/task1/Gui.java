package com.my.lab3.task1;

import com.my.lab3.task1.dao.NumbersDaoImpl;
import com.my.lab3.task1.files.FileHandler;
import javafx.fxml.FXML;

import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.List;
import java.util.Observable;

public class Gui implements java.util.Observer{
    @FXML
    TextField inputFileName;
    @FXML
    TextField outputFileName;
    @FXML
    TextArea numbersList;

//    private NumbersDAO numbers = new NumbersDAO();

    private NumbersDaoImpl numbersDao = new NumbersDaoImpl();
    private Numbers numbers;
    private ConcreteObservable concreteObservable;
//    private FileHandler fileHandler = new FileHandler();

    public Gui(ConcreteObservable concreteObservable) {
        this.concreteObservable = concreteObservable;
        concreteObservable.addObserver(this);
    }
    public void checkText() {
        System.out.println(inputFileName.getText());
    }


    private void setList(List<Double> numbers) {
        StringBuilder str = new StringBuilder();
        for(double el: numbers) {
            str.append(el + "\n");
        }
        numbersList.setText(str.toString());
    }

    public void processNumbers() {
        try {
            numbersDao.getFileHandler().setFileName(inputFileName.getText());
            numbers = numbersDao.getAll();
            numbers.processNumbers();
            numbersDao.getFileHandler().setFileName(outputFileName.getText());
            numbersDao.save(numbers);
            concreteObservable.setResult(numbers.getNumbers());
            concreteObservable.notifyObservers();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void readInput() {
        try {
            numbersDao.getFileHandler().setFileName(inputFileName.getText());
            setList(numbersDao.getAll().getNumbers());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void readOutput() {
        try {
            numbersDao.getFileHandler().setFileName(outputFileName.getText());
            setList(numbersDao.getAll().getNumbers());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable == concreteObservable) setList(concreteObservable.getResult());
    }
}
