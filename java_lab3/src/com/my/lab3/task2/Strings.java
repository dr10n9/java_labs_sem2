package com.my.lab3.task2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class Strings {
    private List<String> strings;

    public Strings(List<String> strings) {
        this.strings = strings;
    }

    public void add(String str) {
        if(!strings.contains(str)) strings.add(str);
    }

    public void delete(String str) {
        if(strings.contains(str)) strings.remove(str);
    }

    public void readFromFile(String fileName) {
        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
            try {
                String str;
                strings.clear();
                while((str = raf.readUTF()) != null) {
                    strings.add(str);
                }
                raf.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
    }

    public void saveToFile(String fileName) {
        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
            try {
                for (String str : strings) {
                    raf.writeUTF(str);
                }
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
    }

    public List<String> getList() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }
}
