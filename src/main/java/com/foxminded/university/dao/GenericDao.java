 package com.foxminded.university.dao;

import java.util.List;

public interface GenericDao<T> {

    public T create(T t);

    public T findById(int id);

    public T update(T t);

    public void delete(T t);

    public List<T> getAll();

}
