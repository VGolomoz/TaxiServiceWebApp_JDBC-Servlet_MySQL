package com.robosh.model.dao.implementations;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * This class respond to connection for database
 *
 * @author Orest Shemelyul
 */
public class ConnectionPoolHolder {
    private static final String DRIVER_DB = "db.connection.driver";
    private static final String URL_DB = "db.connection.url";
    private static final String USERNAME_DB = "db.connection.username";
    private static final String PASSWORD_DB = "db.connection.password";


    private static volatile DataSource dataSource;
    private static final Logger LOG = Logger.getLogger(ConnectionPoolHolder.class);


    /**
     * This method return DataSource
     * and takes parameters from db.properties
     *
     * @return DataSource
     */
    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    LOG.debug("DataSource: " + dataSource);
                    Properties properties = new Properties();
                    String propFileName = "db.properties";
                    LOG.debug("Properties name file: " + propFileName);
                    try (InputStream inputStream = Thread.currentThread()
                            .getContextClassLoader()
                            .getResourceAsStream(propFileName)) {
                        LOG.debug("InputStream: " + inputStream);

                        if (inputStream != null) {
                            LOG.debug("inputStream != null");
                            properties.load(inputStream);
                        } else {
                            LOG.debug("property file '" + propFileName + "' not found in the classpath");
                            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
                        }

                        dataSource = getBasicDataSource(properties);
                    } catch (IOException | ClassNotFoundException e) {
                        LOG.error("File not found " + propFileName);
                    }
                }
            }
        }
        return dataSource;
    }

    private static BasicDataSource getBasicDataSource(Properties properties) throws ClassNotFoundException {
        BasicDataSource ds = new BasicDataSource();
        Class.forName(properties.getProperty(DRIVER_DB));
        ds.setUrl(properties.getProperty(URL_DB));
        ds.setUsername(properties.getProperty(USERNAME_DB));
        ds.setPassword(properties.getProperty(PASSWORD_DB));
        ds.setMinIdle(5);
        ds.setMaxIdle(20);
        ds.setMaxOpenPreparedStatements(100);
        ds.setInitialSize(20);
        return ds;
    }
}
