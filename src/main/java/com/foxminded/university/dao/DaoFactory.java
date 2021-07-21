package com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DaoFactory {

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Context init = new InitialContext();
            DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/UniversityDB");
            connection = ds.getConnection();
        } catch (NamingException ex) {
            throw new DaoException("Cannot retrieve data from UniversityDB", ex);
        }
        return connection;
    }

}
