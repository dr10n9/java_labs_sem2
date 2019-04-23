package com.my.lab3.task1.files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileHandler {
    private final int listSize = 100;

    private String fileName = null;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public FileHandler() {}

    public boolean generateFile() throws IOException {
        if(fileName == null) throw new IllegalStateException("no file name set");
        File file = new File(System.getProperty("user.dir") + "/" + fileName);
        if(!file.isFile()) return false;
        else {
            try {
                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(fileName)
                        )
                );
                for(int i = 0; i < listSize; i++) {
                    dos.writeDouble((Math.random() * 100 - 50));
                }
                dos.close();
                return true;
            } catch (IOException e) {
                throw e;
            }
        }
    }

    public List<Double> getDataFromFile() throws IOException {
        if(fileName == null) throw new IllegalStateException("no file name set");
        try {
            DataInputStream dis = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(fileName)
                    )
            );
            List<Double> res = new ArrayList<>();
            for(int i = 0; i < listSize; i++) {
                res.add(dis.readDouble());
            }
            dis.close();
            return res;
        } catch (IOException e) {
            throw e;
        }
    }

    public boolean writeDataToFile(List<Double> data) throws IOException {
        if(fileName == null) throw new IllegalStateException("no file name set");
        try {
            DataOutputStream dos = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(fileName)
                    )
            );
            for(double el: data) {
                dos.writeDouble(el);
            }
            dos.close();
            return true;
        } catch (IOException e) {
            throw e;
        }
    }

    public void writeEmptyString() throws IOException {
        if(fileName == null) throw new IllegalStateException("no file name");
        try {
            DataOutputStream dos = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(fileName)
                    )
            );
            dos.writeUTF("");
            dos.close();
        } catch (IOException e) {
            throw e;
        }
    }
}
