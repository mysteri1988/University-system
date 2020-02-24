package com.foxminded.university.dao;

import java.util.List;

public interface CrudDao<T> {

    public void create(T t);

    public T findById(int id);

    public void update(T t);

    public void delete(T t);

    public List<T> findAll();
}
