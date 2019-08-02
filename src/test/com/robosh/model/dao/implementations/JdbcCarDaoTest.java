package com.robosh.model.dao.implementations;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.interfaces.CarDao;
import com.robosh.model.entity.Car;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JdbcCarDaoTest {

    private CarDao dao;

    @Before
    public void init() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        dao = daoFactory.createCarDao();
    }

    @After
    public void after() {
    }

    @Test
    public void shouldReturnCarById() {
        Car carActual = dao.getById(1);
        Car expectedCar = new Car();
        expectedCar.setIdCar(1);
        expectedCar.setCarType("wagon");
        expectedCar.setCarNumber("BX3490VC");
        expectedCar.setColor("blue");
        expectedCar.setBrand("Audi");
        assertEquals(expectedCar, carActual);
    }

    @Test
    public void shouldNotReturnCarById() {
        Car carActual = dao.getById(0);
        Car expectedCar = new Car();
        expectedCar.setIdCar(1);
        expectedCar.setCarType("wagon");
        expectedCar.setCarNumber("BX3490VC");
        expectedCar.setColor("blue");
        expectedCar.setBrand("Audi");
        assertNotEquals(expectedCar, carActual);
    }

    @Test
    public void shouldReturnAllCars() {
        List<Car> carsActual = dao.findAll();
        int actualNumberCars = carsActual.size();
        int carsNumberExpected = 7;
        assertEquals(carsNumberExpected, actualNumberCars);
    }

    @Test
    public void shouldReturnTrueIfCarExists() {
        boolean isExistsCar = dao.isSameCarType(1, "wagon");
        assertTrue(isExistsCar);
    }

    @Test
    public void shouldReturnFalseIfCarNotExists() {
        boolean isExistsCar = dao.isSameCarType(1, "23agon");
        assertFalse(isExistsCar);
    }
}