package com.lab7.task1;

public class Point {
    private double x;
    private double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString(){
        StringBuilder sb  = new StringBuilder();
        sb.append("x: " + x + "; y: " + y + "\n");
        return sb.toString();
    }
}
