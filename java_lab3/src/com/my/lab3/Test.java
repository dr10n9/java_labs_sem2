//package com.my.lab3;
//
//import com.my.lab3.task1.dao.NumbersDAO;
//import com.my.lab3.task1.files.FileHandler;
//
//import java.io.IOException;
//import java.util.Optional;
//
//public class Test {
//    public static void main(String [] args) {
//        FileHandler fileHandler = new FileHandler();
//        fileHandler.setFileName("input.txt");
//        try {
//            fileHandler.generateFile();
//        } catch (IOException e) {
//            System.out.println(e.toString());
//        }
//
//
//        NumbersDAO n = new NumbersDAO();
//        n.setFileName("input.txt");
//        n.load();
//        System.out.println(System.getProperty("user.dir"));
//
//        System.out.println(n.getAll().toString());
//        n.getNumbers().processNumbers();
//        n.save();
//    }
//}
