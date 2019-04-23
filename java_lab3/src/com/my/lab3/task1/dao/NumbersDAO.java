//package com.my.lab3.task1.dao;
//
//
//import com.my.lab3.task1.Numbers;
//import com.my.lab3.task1.files.FileHandler;
//import javafx.beans.Observable;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class NumbersDAO implements Dao <Numbers> {
//    private FileHandler fileHandler;
//    private Numbers numbers;
//
//    public NumbersDAO() {
//        numbers = new Numbers();
//        fileHandler = new FileHandler();
//    }
//
//    public NumbersDAO(String filename) {
//        fileHandler = new FileHandler(filename);
//    }
//
//    public NumbersDAO(Numbers numbers) {
//        this.numbers = numbers;
//    }
//
//    public NumbersDAO(Numbers numbers, String filename) {
//        this.numbers = numbers;
//        fileHandler = new FileHandler(filename);
//    }
//
//    @Override
//    public Optional get() {
//        return Optional.of(numbers);
//    }
//
//    @Override
//    public List getAll() {
//        return numbers.getNumbers();
//    }
//
//    @Override
//    public void save() {
//        fileHandler.setFileName("output.txt");
//        try {
//            fileHandler.writeDataToFile(numbers.getNumbers());
//        } catch (IOException e) {
//            System.out.println("IOException on saving");
//        }
//    }
//
//    @Override
//    public void update(Numbers numbers) {
//        this.numbers = numbers;
//    }
//
//    @Override
//    public void delete() {
//        try {
//            this.fileHandler.writeEmptyString();
//        } catch (IOException e) {
//            System.out.println(e.toString());
//        }
//    }
//
//    public void load() {
//        try {
//            numbers.setNumbers(fileHandler.getDataFromFile());
//        } catch (IOException e) {
//            System.out.println("exception on load\n" + e.toString());
//        }
//    }
//
//    public void setFileName(String filename) {
//        fileHandler.setFileName(filename);
//    }
//
//    public Numbers getNumbers() {
//        return numbers;
//    }
//}
