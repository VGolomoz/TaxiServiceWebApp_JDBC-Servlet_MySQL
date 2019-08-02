package com.robosh.model.dao.mappers;

import com.robosh.model.dao.implementations.queries.fieldsDatabase.DriverFields;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.enums.DriverStatus;
import com.robosh.model.entity.enums.Role;
import com.robosh.service.CarService;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * class that implements Mapper interface
 *
 * @author Orest Shemelyuk
 */
public class DriverMapper implements Mapper<Driver> {
    @Override
    public Driver getEntity(ResultSet resultSet) throws SQLException {
        Driver driver = new Driver();
        CarService carService = new CarService();
        driver.setPersonId(resultSet.getInt(DriverFields.ID_DRIVER));
        driver.setSurname(resultSet.getString(DriverFields.SURNAME));
        driver.setName(resultSet.getString(DriverFields.NAME));
        driver.setMiddleName(resultSet.getString(DriverFields.MIDDLE_NAME));
        driver.setPassword(resultSet.getString(DriverFields.PASSWORD));
        driver.setPhoneNumber(resultSet.getString(DriverFields.PHONE_NUMBER));
        driver.setDriverStatus(toDriverStatus(resultSet.getString(DriverFields.DRIVER_STATUS)));
        driver.setRole(Role.DRIVER);
        driver.setCar(carService.getCarById(resultSet.getInt(DriverFields.ID_CAR_DRIVER)));
        return driver;
    }

    private DriverStatus toDriverStatus(String status) {
        if (DriverStatus.BOOKED.toString()
                .equalsIgnoreCase(status)) {
            return DriverStatus.BOOKED;
        } else {
            return DriverStatus.FREE;
        }
    }
}
