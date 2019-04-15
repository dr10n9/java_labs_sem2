package com.my.lab2.task2;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ConcreteObservable extends java.util.Observable {
    private ArrayList<Observer> observers;
    private ArrayList<String> result;

    public ConcreteObservable() {
        observers = new ArrayList<>();
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update(this, null);
        }
    }

    @Override
    public synchronized void addObserver(Observer observer) {
        if(!observers.contains(observer)) observers.add(observer);
    }

    @Override
    public synchronized void deleteObserver(Observer observer) {
        if(observers.contains(observer)) observers.remove(observer);
    }

    public void setResult(ArrayList<String> result) {
        this.result = result;
        notifyObservers();
    }

    public ArrayList<String> getResult() {
        return result;
    }
}
