package com.robosh.model.dao.implementations;

import com.robosh.model.dao.*;
import com.robosh.model.dao.interfaces.*;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * JdbcDaoFactory that extends DaoFactory and return connection
 */
public class JdbcDaoFactory extends DaoFactory {

    private static final Logger LOG = Logger.getLogger(JdbcDaoFactory.class);
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public ClientDao createClientDao() {
        return new JdbcClientDao(getConnection());
    }

    @Override
    public AddressDao createAdressDao() {
        return new JdbcAddressDao(getConnection());
    }

    @Override
    public DriverDao createDriverDao() {
        return new JdbcDriverDao(getConnection());
    }

    @Override
    public CarDao createCarDao() {
        return new JdbcCarDao(getConnection());
    }

    @Override
    public CouponDao createCouponDao() {
        return new JdbcCouponDao(getConnection());
    }

    @Override
    public OrderDao createOrderDao() {
        return new JdbcOrderDao(getConnection());
    }

    private Connection getConnection() {
        try {
            LOG.debug("getConnection: " + dataSource);
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOG.debug("SQLException occurred", e);
            throw new RuntimeException(e);
        }
    }

}
