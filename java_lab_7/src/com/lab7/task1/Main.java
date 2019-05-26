package com.lab7.task1;

import com.lab7.task1.*;


public class Main {
    public Main(){
        Queue q = new Queue();
        Generator g = new Generator(q);
        Consumer c = new Consumer(q, this);
    }
    public static void main(String [] args){
        new Main();
    }

    public synchronized void printSquare(Double square) {
        System.out.println("Main thread: square = " + square);
    }
}
