package com.egor.jsp.project.facades;


import java.util.List;

public interface Facade<T> {

    void create(T object);

    void update(T object);

    void remove(String id);

    T findById(String id);

    List<T> findAllRecords();
}
