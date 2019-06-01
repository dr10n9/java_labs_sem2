package com.test;

public class CustomException extends Exception{
    private static final long serialVersionUID = 1L; // ?
    private int number;
    public int getNumber() {
        return number;
    }

    public CustomException(String message, int number) {
        super(message);
        this.number = number;
    }
}