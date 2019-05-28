package com.lab7.task1;

import java.util.ArrayList;

public class Queue {
    private boolean pointsSet = false;
    private boolean squareSet = false;
    private double square;
    ArrayList<Point> points = new ArrayList<>();

    synchronized ArrayList<Point> getPoints(){
        while (!pointsSet) try {
            wait();
        } catch (InterruptedException e) {
            System.err.println(e.toString());
        }
        System.out.println(Thread.currentThread().getName() + ": getting points");
        pointsSet = false;
        notify();
        return points;
    }

    synchronized void setPoints(ArrayList<Point> points) {
        while(pointsSet) try {
            wait();
        } catch (InterruptedException e) {
            System.err.println(e.toString());
        }
        this.points = points;
        System.out.println(Thread.currentThread().getName() + ": points set");
        pointsSet = true;
        notify();
    }

    synchronized void setSquare(double square) {
        while(squareSet) try {
            wait();
        } catch(InterruptedException e) {
            System.err.println(e.toString());
        }
        this.square = square;
        System.out.println(Thread.currentThread().getName() + ": square set");
        squareSet = true;
        notify();
    }

    synchronized void printSquare() {
        System.out.println("QUEUE INFO: pointsSet: " + pointsSet + " | squareSet: " + squareSet);
        while(!squareSet) try {
            wait();
        } catch (InterruptedException e) {

        }
        System.out.println(Thread.currentThread().getName() + ": square=" + square);
        squareSet = false;
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }

}
