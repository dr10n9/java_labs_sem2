package com.my.lab6;

public class Progression {
    public double a0;
    public double step;

    public Progression() {
        a0 = 0;
        step = 0;
    }

    public Progression(double a0, double step) {
        this.a0 = a0;
        this.step = step;
    }

    public double getSum(int n) {
        double denominator;
        if(step == 1) denominator = 0;
        else denominator = 1 - step;
        return  (a0 - getMember(n) * step) / denominator;
    }

    public double getSumWithStandartExcpetion(int n) throws ArithmeticException {
        if(step == 1) throw new ArithmeticException("division by zero");
        return (a0 - getMember(n) * step)/(1 - step);
    }

    public double getSumWithCustomException(int n) throws ProgressionException {
        if(step == 1) throw new ProgressionException("division by zero");
        return (a0 - getMember(n) * step)/(1 - step);
    }

    public double getMember(int index) {
        return a0 * Math.pow(step, index - 1);
    }

    public static void main(String [] args) {
        Progression p = new Progression(5, 1);
        try {
            System.out.println(p.getSumWithCustomException(10));
        } catch (ProgressionException e) {
            System.out.println(e.toString());
        }
    }
}
