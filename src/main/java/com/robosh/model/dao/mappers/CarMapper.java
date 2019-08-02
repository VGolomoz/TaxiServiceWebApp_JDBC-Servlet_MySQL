package com.robosh.model.dao.mappers;

import com.robosh.model.dao.implementations.queries.fieldsDatabase.CarFields;
import com.robosh.model.entity.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * class that implements Mapper interface
 *
 * @author Orest Shemelyuk
 */
public class CarMapper implements Mapper<Car> {
    @Override
    public Car getEntity(ResultSet resultSet) throws SQLException {
        Car car = new Car();
        car.setIdCar(resultSet.getInt(CarFields.ID_CAR));
        car.setCarNumber(resultSet.getString(CarFields.NUMBER));
        car.setBrand(resultSet.getString(CarFields.BRAND));
        car.setColor(resultSet.getString(CarFields.COLOR));
        car.setCarType(resultSet.getString(CarFields.CAR_TYPE));
        return car;
    }
}
