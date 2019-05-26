package com.lab7.task1;

import java.util.ArrayList;
import java.util.Random;

public class Generator implements Runnable {
    Random r = new Random();
    Queue q;
    public Generator(Queue q) {
        this.q = q;
        new Thread(this, "Generator").start();
    }

    public void run() {
        while (true) {
            ArrayList<Point> list = new ArrayList<>();
            list.add(new Point(r.nextDouble() * 50, r.nextDouble() * 50));
            list.add(new Point(r.nextDouble() * 50, r.nextDouble() * 50));
            list.add(new Point(r.nextDouble() * 50, r.nextDouble() * 50));
            System.out.println("generated new points");
            q.set(list);
        }
    }
}