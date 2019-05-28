package com.lab7.task1;

public class Main {
    public Main(){
        Queue q = new Queue();
        Generator g = new Generator(q);
        Consumer c = new Consumer(q);
    }
    public static void main(String [] args){
        final Queue q = new Queue();
        Generator g = new Generator(q);
        Consumer c = new Consumer(q);

         while(true) q.printSquare();
    }

    public synchronized void printSquare(Double square) {
        System.out.println(Thread.currentThread().getName() +": square = " + square);
    }
}
