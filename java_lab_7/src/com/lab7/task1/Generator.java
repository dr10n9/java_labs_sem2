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

    public ArrayList<Point> generateList() {
        ArrayList<Point> points = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            Point p = new Point(r.nextDouble() * 25, r.nextDouble() * 25);
            points.add(p);
        }
        return points;
    }

    @Override
    public void run() {
        while(true) {
            q.setPoints(generateList());
        }
    }
}