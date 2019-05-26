package com.lab7.task1;

import java.util.ArrayList;

public class Triangle {
    private ArrayList<Point> points;
    public Triangle(ArrayList<Point> points) {
        this.points = points;
    }

    public double getSquare() {
        double[][] arr = new double[2][2];
        arr[0][0] = points.get(0).getX() - points.get(2).getX();
        arr[0][1] = points.get(0).getY() - points.get(2).getY();
        arr[1][0] = points.get(1).getX() - points.get(2).getX();
        arr[1][1] = points.get(1).getY() - points.get(2).getY();
        return Math.abs((arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0])/2);
    }

    public static void main(String [] args) {
        ArrayList<Point> p = new ArrayList<>();
        p.add(new Point(0, 0));
        p.add(new Point(2, 0));
        p.add(new Point(0, 2));
        Triangle t = new Triangle(p);
        System.out.println(t.getSquare());
    }
}
