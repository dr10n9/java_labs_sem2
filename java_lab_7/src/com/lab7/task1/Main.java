package com.lab7.task1;

import com.lab7.task1.*;


public class Main {
    public static void main(String [] args){
        Queue q = new Queue();
        Generator g = new Generator(q);
        Consumer c = new Consumer(q, new Main());
    }

    public void printSquare(Double square) {
        System.out.println("Main thread: square = " + square);
    }
}
