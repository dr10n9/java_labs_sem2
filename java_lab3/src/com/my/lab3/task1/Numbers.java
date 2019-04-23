package com.my.lab3.task1;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Double> numbers = null;

    public List<Double> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Double> numbers) {
        this.numbers = numbers;
    }

    public Numbers() { this.numbers = new ArrayList<>(); }

    public Numbers(List<Double> numbers) {
        this.numbers = numbers;
    }

    public double getAverage() {
        if(numbers == null) throw new IllegalStateException("now list set");
        double average = 0;
        for(double el: numbers) {
            average += el;
        }
        return average/numbers.size();
    }

    public void processNumbers() {
        int len = numbers.size();
        for(int i = 0; i < len; i++) {
            if(numbers.get(i) == 0) numbers.set(i, getAverage());
        }
    }
}
