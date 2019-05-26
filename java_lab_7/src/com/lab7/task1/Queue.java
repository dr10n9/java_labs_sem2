package com.lab7.task1;

import java.util.ArrayList;

public class Queue {
    boolean valueSet;
    ArrayList<Point> points = new ArrayList<>();

    synchronized ArrayList<Point> get(){
        while(!valueSet) try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
        valueSet = false;
        notify();
        return points;
    }

    synchronized void set(ArrayList<Point> points) {
        while(valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
            this.points = points;
            valueSet = true;
            notify();
    }

}
