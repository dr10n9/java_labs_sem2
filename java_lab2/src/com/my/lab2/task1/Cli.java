package com.my.lab2.task1;

import java.util.List;
import java.util.Scanner;

public class Cli implements Observer{
    Numbers numbers;
    Scanner sc;
    ConcreteObservable concreteObservable;

    public Cli() {
        numbers = new Numbers();
        sc = new Scanner(System.in);
    }

    public Cli(ConcreteObservable concreteObservable) {
        numbers = new Numbers();
        sc = new Scanner(System.in);
        this.concreteObservable = concreteObservable;
        this.concreteObservable.registerObserver(this);
    }

    public int readQuantity() throws Exception {
        System.out.print("input quantity of numbers: ");
        try {
            int n = sc.nextInt();
            if(n <= 0) throw new Exception("wrong quantity of numbers");
            return n;
        } catch (Exception e) {
            throw e;
        }
    }

    public void readNumbers() {
        try {
            int n = readQuantity();
            for(int i = 0; i < n; i++) {
                System.out.printf("numbers[%d]: ", i);
                this.numbers.add(sc.nextInt());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void run() {
        while(true) {
            try {
                readNumbers();
                List<Integer> lucky = numbers.getLuckyNumbers();
                concreteObservable.setLuckyNumbers(lucky);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    @Override
    public void update(List<Integer> numbers) {
        System.out.println(numbers.toString());
    }
}
