package com.robosh.model.dao.interfaces;

import com.robosh.model.entity.Car;

public interface CarDao extends Dao<Car> {
    boolean isSameCarType(int id_car, String carType);
}
