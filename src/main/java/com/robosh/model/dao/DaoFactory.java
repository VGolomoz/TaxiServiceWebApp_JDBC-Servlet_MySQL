package com.robosh.model.dao;

import com.robosh.model.dao.implementations.JdbcDaoFactory;
import com.robosh.model.dao.interfaces.*;
import org.apache.log4j.Logger;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;
    private static final Logger LOG = Logger.getLogger(DaoFactory.class);

    public abstract ClientDao createClientDao();

    public abstract AddressDao createAdressDao();

    public abstract DriverDao createDriverDao();

    public abstract CarDao createCarDao();

    public abstract CouponDao createCouponDao();

    public abstract OrderDao createOrderDao();

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    LOG.debug("creating dao factory");
                    daoFactory = new JdbcDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
