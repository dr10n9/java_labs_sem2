package com.my.lab3.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class ConcreteObservable extends java.util.Observable {
    private List<Observer> observers;
    private List<Double> result;

    public ConcreteObservable() {
        observers = new ArrayList<>();
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observers) {
            observer.update(this, null);
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

    public void setResult(List<Double> result) {
        this.result = result;
    }

    public List<Double> getResult() {
        return result;
    }
}
