package com.robosh.model.dao.implementations;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.interfaces.ClientDao;
import com.robosh.model.entity.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JdbcClientDaoTest {
    private ClientDao dao;

    @Before
    public void init() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        dao = daoFactory.createClientDao();
    }

    @After
    public void after() {
    }

    @Test
    public void shouldReturnTrueIfPhoneNumberExists() {
        boolean phoneNumberExistsActual = dao.isPhoneNumberExists("+380976970365");
        assertTrue(phoneNumberExistsActual);
    }

    @Test
    public void shouldReturnFalseIfPhoneNumberNotExists() {
        boolean phoneNumberNotExistsActual = dao.isPhoneNumberExists("+380006970365");
        assertFalse(phoneNumberNotExistsActual);
    }

    @Test
    public void shouldReturnTrueIfEmailExists() {
        boolean emailExistsActual = dao.isEmailExists("orestshemelyuk@gmail.com");
        assertTrue(emailExistsActual);
    }


    @Test
    public void shouldReturnFalseIfEmailExists() {
        boolean emailNotExistsActual = dao.isEmailExists("notexists@gmaill.com");
        assertFalse(emailNotExistsActual);
    }

    @Test
    public void shouldReturnClientByPassPhone() {
        Client clientActual = dao.getClientByPassPhone("+380976970365", "rootroot");
        Client clientExpected = new Client();
        clientExpected.setPersonId(1);
        clientExpected.setPassword("rootroot");
        clientExpected.setEmail("orestshemelyuk@gmail.com");
        clientExpected.setPhoneNumber("+380976970365");
        clientExpected.setSurname("Шемелюк");
        clientExpected.setName("Орест");
        assertEquals(clientExpected, clientActual);
    }

    @Test
    public void shouldNotReturnClientByPassPhone() {
        Client clientActual = dao.getClientByPassPhone("+380976900365", "rootroot");
        Client clientExpected = new Client();
        clientExpected.setPersonId(1);
        clientExpected.setPassword("rootroot");
        clientExpected.setEmail("orestshemelyuk@gmail.com");
        clientExpected.setPhoneNumber("+380976970365");
        clientExpected.setSurname("Шемелюк");
        clientExpected.setName("Орест");
        assertNotEquals(clientExpected, clientActual);
    }

    @Test
    public void shouldReturnClientById() {
        Client actualClient = dao.getById(1);
        Client clientExpected = new Client();
        clientExpected.setPersonId(1);
        clientExpected.setPassword("rootroot");
        clientExpected.setEmail("orestshemelyuk@gmail.com");
        clientExpected.setPhoneNumber("+380976970365");
        clientExpected.setSurname("Шемелюк");
        clientExpected.setName("Орест");
        assertEquals(clientExpected, actualClient);
    }

    @Test
    public void shouldNotReturnClientById() {
        Client actualClient = dao.getById(0);
        Client clientExpected = new Client();
        clientExpected.setPersonId(1);
        clientExpected.setPassword("rootroot");
        clientExpected.setEmail("orestshemelyuk@gmail.com");
        clientExpected.setPhoneNumber("+380976970365");
        clientExpected.setSurname("Шемелюк");
        clientExpected.setName("Орест");
        assertNotEquals(clientExpected, actualClient);
    }
}