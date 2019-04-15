package com.my.lab2.task2;

import java.util.*;

public class Cli implements Observer {
    private ConcreteObservable concreteObservable;

    public Cli(ConcreteObservable concreteObservable) {
        this.concreteObservable = concreteObservable;
        this.concreteObservable.addObserver(this);
    }

    public void checkStrigns() {
        System.out.print("input words: ");
        String input = new Scanner(System.in).nextLine();
        TextContainer tc = new TextContainer(input);
        List<String> listOfWords = tc.getUniqueWhereFirstEqualsLast();
        StringBuilder resultingString = new StringBuilder();
        for(String word : listOfWords){
            resultingString.append(word).append(" ");
        }
        concreteObservable.setResult(new ArrayList(listOfWords));
    }


    @Override
    public void update(java.util.Observable observable, Object o) {
        if(observable == this.concreteObservable) {
            System.out.println(this.concreteObservable.getResult().toString());
        }
    }

    public void run() {
        while(true) {
            checkStrigns();
        }
    }
}
