package com.robosh.model.dao.implementations;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.interfaces.AddressDao;
import com.robosh.model.entity.Address;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JdbcAddressDaoTest {

    private AddressDao dao;

    @Before
    public void init() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        dao = daoFactory.createAdressDao();
    }

    @After
    public void after() {
    }

    @Test
    public void shouldReturnTrueIfExistsAddress() {
        boolean isAddressExists = dao.checkAddressExist("Янгеля", "12");
        assertTrue(isAddressExists);
    }

    @Test
    public void shouldReturnFalseIfNotExistsAddress() {
        boolean addressNotExists = dao.checkAddressExist("asdf", "12");
        assertFalse(addressNotExists);
    }

    @Test
    public void shouldReturnAddressIdIfAddressExists() {
        int idAddress = dao.getAddressId("Янгеля", "12");
        assertEquals(1, idAddress);
    }

    @Test
    public void shouldReturnOneIfAddressNotExists() {
        int idAddress = dao.getAddressId("zxvb", "12");
        assertEquals(-1, idAddress);
    }

    @Test
    public void shouldReturnAddressByStreetNumberHouse() {
        Address addressExpected = dao.getAddressByStreetNumberHouse("Янгеля", "12");
        Address addressActual = new Address();
        addressActual.setIdAddress(1);
        addressActual.setStreet("Янгеля");
        addressActual.setHouseNumber("12");
        assertEquals(addressActual, addressExpected);
    }

    @Test
    public void shouldNotReturnAddressByStreetNumberHouse() {
        Address addressExpected = dao.getAddressByStreetNumberHouse("Янеля", "2");
        Address addressActual = new Address();
        addressActual.setIdAddress(1);
        addressActual.setStreet("Янгеля");
        addressActual.setHouseNumber("12");
        assertNotEquals(addressActual, addressExpected);
    }
}