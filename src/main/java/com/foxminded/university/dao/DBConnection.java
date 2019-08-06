package com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.foxminded.university.ui.ServletException;

public class DBConnection {

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Context init = new InitialContext();
            Context ctx = (Context) init.lookup("java:comp/env");
            javax.sql.DataSource ds = (DataSource) ctx.lookup("jdbc/UniversityDB");
            connection = ds.getConnection();
        } catch (NamingException ex) {
            throw new ServletException("Cannot retrieve java:comp/env/jdbc/MyLocalDB", ex);
        }
        return connection;
    }
}
