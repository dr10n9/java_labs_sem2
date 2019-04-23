package com.my.lab3.task1;

import com.my.lab3.task1.dao.NumbersDaoImpl;

import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

public class Cli implements java.util.Observer {
    private ConcreteObservable concreteObservable;

    private NumbersDaoImpl numbersDao;
    private Numbers numbers;

    private String inputFileName;
    private String outputFileName;


    public Cli(ConcreteObservable concreteObservable) {
        this.concreteObservable = concreteObservable;
        this.concreteObservable.addObserver(this);
        numbersDao = new NumbersDaoImpl();
        numbers = new Numbers();
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable == concreteObservable) {
            System.out.println(concreteObservable.getResult().toString());
        }
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input file name: ");
        inputFileName = sc.nextLine();
        System.out.println("Output file name: ");
        outputFileName = sc.nextLine();
        doNumbers();
    }

    public void run() {
        while(true) {
            read();
        }
    }

    void doNumbers() {
        try {
            numbersDao.getFileHandler().setFileName(inputFileName);
            numbers = numbersDao.getAll();
            numbersDao.getFileHandler().setFileName(outputFileName);
            numbers.processNumbers();
            numbersDao.save(numbers);
            concreteObservable.setResult(numbers.getNumbers());
            concreteObservable.notifyObservers();
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }

}
