package com.foxminded.university.dao;

import java.util.List;

public interface GenericDao<T> {

    public T create(T t) throws DaoException;

    public T findById(int id) throws DaoException;

    public T update(T t) throws DaoException;

    public void delete(T t) throws DaoException;

    public List<T> getAll() throws DaoException;

}
