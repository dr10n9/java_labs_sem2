package com.lab7.task1;

public class Consumer implements Runnable{
    Queue q;
    Main instance;
    public Consumer (Queue q, Main main) {
        this.q = q;
        instance = main;
        new Thread(this, "Consumer").start();
    }

    public void run(){
        while (true) {
            Triangle t = new Triangle(q.get());
            try {
                instance.printSquare(t.getSquare());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
        }
    }

}
