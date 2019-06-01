package com.test;

import java.util.List;
import java.util.ArrayList;

public class Progression {
    private double delta;
    private double a_0;
    private List<Double> progressionList = new ArrayList<>();
    public Progression(double a_0, double delta) {
        this.a_0 = a_0;
        this.delta = delta;
        progressionList.add(a_0);
    }

    public double next() {
        double next = progressionList.get(progressionList.size() - 1) * delta;
        progressionList.add(next);
        return next;
    }

    public double a_n(int n) {
        return a_0 * Math.pow(delta, n - 1);
    }

    public double sum(int n) {
        double sum = a_0 * (Math.pow(delta, n) - 1)/(delta - 1);
        return sum;
    }

    public double sum() {
        double sum = 0.0;
        for(double el: progressionList) {
            sum += el;
        }
        return sum;
    }

    public void throwException() throws CustomException{
        throw new CustomException("throwed CustumException", 123);
    }
}