package com.foxminded.university.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DaoProperties {

    private final static Logger log = LogManager.getLogger(DaoProperties.class);
    private static final String PROPERTIES_FILE = "dao.properties";
    private static final Properties PROPERTIES = new Properties();

    void loadProperty() throws DaoConfigurationException {
        log.trace("Create classLoader for property file");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        log.trace("Load property_file in stream");
        InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);
        if (propertiesFile == null) {
            log.error("An exception occured because the property file is missing");
            throw new DaoConfigurationException("Property file " + PROPERTIES_FILE + " is missing in classpath.");
        }
        try {
            log.trace("Load propertiesFile");
            PROPERTIES.load(propertiesFile);
        } catch (IOException e) {
            log.error("An exception occured in process of loading property file", e);
            throw new DaoConfigurationException("Cannot load properties file " + PROPERTIES_FILE + ". ", e);
        }
    }

    public String getProperty(String key) throws DaoConfigurationException {
        log.trace("Get property from properties file");
        String property = PROPERTIES.getProperty(key);
        if (property == null || property.trim().length() == 0) {
            log.error("An exception occured becaue in property file the key is missing");
            throw new DaoConfigurationException(
                    "Required property " + key + " is missing in properties file " + PROPERTIES_FILE + " .");
        }
        log.trace("Return peroperty");
        return property;
    }

}
