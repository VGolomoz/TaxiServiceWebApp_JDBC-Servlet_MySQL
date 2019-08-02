package com.robosh.service;

import com.robosh.model.dao.interfaces.CarDao;
import com.robosh.model.dao.DaoFactory;
import com.robosh.model.entity.Car;
import org.apache.log4j.Logger;

import java.util.List;

public class CarService {

    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static final Logger LOG = Logger.getLogger(CarService.class);

    public Car getCarById(int id){
        try (CarDao dao = daoFactory.createCarDao()) {
            LOG.debug("created CarDao");
            return dao.getById(id);
        }
    }

    public List<Car> getAllCars(){
        try(CarDao dao = daoFactory.createCarDao()){
            LOG.debug("created CarDao");
            return dao.findAll();
        }
    }

    public boolean findCarByIdAndCarType(int id_car, String type){
        try (CarDao dao = daoFactory.createCarDao()) {
            LOG.debug("created CarDao");
            return dao.isSameCarType(id_car, type);
        }
    }

}
