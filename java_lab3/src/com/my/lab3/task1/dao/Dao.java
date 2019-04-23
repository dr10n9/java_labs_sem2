package com.my.lab3.task1.dao;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {

//    Optional<T> get();

//    List<T> getAll();

//    void update(T t);

    T getAll() throws IOException;

    void save(T t) throws IOException;

    void delete() throws IOException;
}
