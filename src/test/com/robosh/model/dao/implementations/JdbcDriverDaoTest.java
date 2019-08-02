package com.robosh.model.dao.implementations;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.interfaces.DriverDao;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.enums.DriverStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JdbcDriverDaoTest {
    private DriverDao dao;

    @Before
    public void init() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        dao = daoFactory.createDriverDao();
    }

    @After
    public void after() {
    }

    @Test
    public void shouldReturnDriverById() {
        Driver actualDriver = dao.getById(1);
        actualDriver.setDriverStatus(DriverStatus.FREE);
        actualDriver.setCar(null);
        Driver driverExpected = new Driver();
        driverExpected.setPersonId(1);
        driverExpected.setName("Андрій");
        driverExpected.setSurname("Карпенко");
        driverExpected.setMiddleName("Олександрович");
        driverExpected.setDriverStatus(DriverStatus.FREE);
        driverExpected.setPhoneNumber("+380983445123");
        driverExpected.setPassword("qwerty");
        assertEquals(driverExpected, actualDriver);
    }

    @Test
    public void shouldNotReturnDriverById() {
        Driver actualDriver = dao.getById(0);
        int actualDriverId = actualDriver.getPersonId();
        int expectedId = -1;
        assertEquals(expectedId, actualDriverId);
    }

    @Test
    public void shouldReturnAllDrivers() {
        List<Driver> driversActual = dao.findAll();
        int driverNumberActual = driversActual.size();
        int expectedNumberDrivers = 7;
        assertEquals(expectedNumberDrivers, driverNumberActual);
    }

    @Test
    public void shouldNotReturnAllDrivers() {
        List<Driver> driversActual = dao.findAll();
        int driverNumberActual = driversActual.size();
        int expectedNumberDrivers = 0;
        assertNotEquals(expectedNumberDrivers, driverNumberActual);
    }

    @Test
    public void shouldReturnTrueIfDriverExists() {
        boolean driverExistActual = dao.isDriverExist("+380983445123", "qwerty");
        assertTrue(driverExistActual);
    }

    @Test
    public void shouldReturnFalseIfDriverNotExists() {
        boolean driverNotExistActual = dao.isDriverExist("+2134322131", "qwertt");
        assertFalse(driverNotExistActual);
    }

    @Test
    public void shouldReturnDriverByPassAndPhone() {
        Driver actualDriver = dao.getDriverByPassAndPhone("+380983445123", "qwerty");
        actualDriver.setDriverStatus(DriverStatus.FREE);
        actualDriver.setCar(null);
        Driver driverExpected = new Driver();
        driverExpected.setPersonId(1);
        driverExpected.setName("Андрій");
        driverExpected.setSurname("Карпенко");
        driverExpected.setMiddleName("Олександрович");
        driverExpected.setDriverStatus(DriverStatus.FREE);
        driverExpected.setPhoneNumber("+380983445123");
        driverExpected.setPassword("qwerty");
        assertEquals(driverExpected, actualDriver);
    }

    @Test
    public void shouldNotReturnDriverByPassAndPhone() {
        Driver actualDriver = dao.getDriverByPassAndPhone("+380983445144", "qwedsfty");
        int actualId = actualDriver.getPersonId();
        int expectedId = -1;
        assertEquals(expectedId, actualId);
    }
}