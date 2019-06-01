package com.my.lab6;

import java.util.Objects;

public class Progression {
    private double a0;
    private double step;

    public Progression() {
        a0 = 0;
        step = 0;
    }

    public Progression(double a0, double step) {
        this.a0 = a0;
        this.step = step;
    }

    public double getSum(int n) {
        if(step == 1) return  (a0 - getMember(n) * step) / 0;
        else return  (a0 - getMember(n) * step) / 1 - step;
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

    public double getA0() {
        return a0;
    }

    public void setA0(double a0) {
        this.a0 = a0;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Progression)) return false;
        Progression that = (Progression) o;
        return Double.compare(that.a0, a0) == 0 &&
                Double.compare(that.step, step) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a0, step);
    }

    @Override
    public String toString() {
        return "Progression{" +
                "a0=" + a0 +
                ", step=" + step +
                '}';
    }
}
