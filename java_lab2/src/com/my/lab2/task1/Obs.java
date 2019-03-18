package com.my.lab2.task1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Obs implements Observable{
    List<Observer> observers;
    List luckyNumbers;
    public Obs() {
        observers = new LinkedList<Observer>();
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(luckyNumbers);
        }
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void setLuckyNumbers(List<Integer> luckyNumbers) {
        this.luckyNumbers = luckyNumbers;
        notifyObservers();
    }
}
