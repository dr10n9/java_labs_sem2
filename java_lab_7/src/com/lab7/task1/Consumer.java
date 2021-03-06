package com.lab7.task1;

public class Consumer implements Runnable{
    Queue q;

    public Consumer (Queue q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        while(true) {
            q.setSquare(new Triangle(q.getPoints()).getSquare());
        }
    }

}