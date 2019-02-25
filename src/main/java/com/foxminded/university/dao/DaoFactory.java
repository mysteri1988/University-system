package com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DaoFactory {

    private final static Logger log = LogManager.getLogger(DaoFactory.class);

    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_USERNAME = "username";
    private static final String PROPERTY_PASSWORD = "password";
    private static final String PROPERTY_DRIVER = "driver";

    private static volatile DaoFactory daoFactory;

    private static DaoProperties properties = new DaoProperties();

    private DaoFactory() {
        log.trace("Load properties from property file");
        properties.loadProperty();
        log.trace("Get driverClassName from properties");
        String driverClassName = properties.getProperty(PROPERTY_DRIVER);
        try {
            log.trace("Get driverClassName for data base");
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            log.error("An exception occured in process of loading {1}",driverClassName,e);
            throw new DaoConfigurationException("Driver class " + driverClassName + " is missing path.", e);
        }
    }

    public Connection getConnection() throws SQLException {
        log.trace("Load credentials from properties file");
        String url = properties.getProperty(PROPERTY_URL);
        String password = properties.getProperty(PROPERTY_PASSWORD);
        String username = properties.getProperty(PROPERTY_USERNAME);
        log.trace("Return connection");
        return DriverManager.getConnection(url, username, password);
    }

    public static DaoFactory getInstance() {
        DaoFactory localDaoFactory = daoFactory;
        if (localDaoFactory == null) {
            synchronized (DaoFactory.class) {
                localDaoFactory = daoFactory;
                if (localDaoFactory == null) {
                    daoFactory = localDaoFactory = new DaoFactory();
                }
            }
        }
        return localDaoFactory;

    }

}
