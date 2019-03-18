package com.my.lab2.task1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Numbers {
    private final int initCounter = 2;
    private List<Integer> numbers = new ArrayList<Integer>();
    public Numbers(){}

    public Numbers(Integer[] numbers){
        for(int i = 0; i < numbers.length; i++){
            this.numbers.add(numbers[i]);
        }
    }
    public List<Integer> getLuckyNumbers(){
        if(this.numbers.size() != 0){
            List<Integer> lucky = new ArrayList<Integer>();
            for(int i = 0; i < numbers.size(); i++){
                if(isLucky(numbers.get(i), initCounter)) lucky.add(numbers.get(i));
            }
            return lucky;
        }
        return Collections.emptyList();
    }
    public void add(int number){
        this.numbers.add(number);
    }

    private boolean isLucky(int n, int counter) {
        if(n % counter == 0) return false;
        if(n < counter) return true;
        n -= n/counter;
        counter++;
        return isLucky(n, counter);
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
