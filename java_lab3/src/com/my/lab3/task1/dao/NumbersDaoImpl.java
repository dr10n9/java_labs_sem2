package com.my.lab3.task1.dao;

import com.my.lab3.task1.Numbers;
import com.my.lab3.task1.files.FileHandler;

import java.io.IOException;

public class NumbersDaoImpl implements Dao<Numbers> {
    private FileHandler fileHandler;
    public NumbersDaoImpl() {
        fileHandler = new FileHandler();
    }

    @Override
    public void save(Numbers numbers) throws IOException {
        try {
            fileHandler.writeDataToFile(numbers.getNumbers());
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public Numbers getAll() throws IOException {
        try {
            return new Numbers(fileHandler.getDataFromFile());
        } catch (IOException e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    @Override
    public void delete() throws IOException {
        try {
            fileHandler.writeEmptyString();
        } catch (IOException e) {
            throw e;
        }
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }
}
