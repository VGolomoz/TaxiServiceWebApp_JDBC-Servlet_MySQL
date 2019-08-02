package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.interfaces.DriverDao;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.enums.DriverStatus;
import org.apache.log4j.Logger;

import java.util.List;

public class DriverService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static final Logger LOG = Logger.getLogger(DriverService.class);


    public boolean isDriverExists(String phoneNumber, String password){
        try (DriverDao dao = daoFactory.createDriverDao()){
            LOG.debug("created DriverDao");
            return dao.isDriverExist(phoneNumber, password);
        }
    }

    public Driver getDriverByPasswordAndPhone(String phoneNumber, String password){
        try(DriverDao dao = daoFactory.createDriverDao()){
            LOG.debug("created DriverDao");
            return dao.getDriverByPassAndPhone(phoneNumber, password);
        }
    }

    public Driver getDriverById(int id) {
        try (DriverDao dao = daoFactory.createDriverDao()) {
            LOG.debug("created DriverDao");
            return dao.getById(id);
        }
    }

    public List<Driver> getAllDrivers() {
        try (DriverDao dao = daoFactory.createDriverDao()) {
            LOG.debug("created DriverDao");
            return dao.findAll();
        }
    }

    public Driver getDriverByCarTypeAndDriverStatus(DriverStatus driverStatus, String carType) {
        try (DriverDao dao = daoFactory.createDriverDao()) {
            LOG.debug("created DriverDao");
            return dao.getDriverByCarTypeAndDriverStatus(driverStatus, carType);
        }
    }

    public boolean updateDriverStatus(Driver driver) {
        try (DriverDao dao = daoFactory.createDriverDao()) {
            LOG.debug("created DriverDao");
            return dao.update(driver);
        }
    }
}
