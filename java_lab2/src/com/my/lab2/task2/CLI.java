package com.my.lab2.task2;

import java.util.*;

public class CLI implements Observer {
    private Obs obs;

    public CLI(Obs obs) {
        this.obs = obs;
        this.obs.addObserver(this);
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
        obs.setResult(new ArrayList(listOfWords));
    }


    @Override
    public void update(Observable observable, Object o) {
        if(observable == obs) {
            System.out.println(obs.getResult().toString());
        }
    }

    public void run() {
        while(true) {
            checkStrigns();
        }
    }
}
