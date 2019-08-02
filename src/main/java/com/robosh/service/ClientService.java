package com.robosh.service;

import com.robosh.model.customExceptions.EmailIsAlreadyTaken;
import com.robosh.model.customExceptions.PhoneNumberIsAlreadyTaken;
import com.robosh.model.dao.interfaces.ClientDao;
import com.robosh.model.dao.DaoFactory;
import com.robosh.model.entity.Client;
import org.apache.log4j.Logger;

import java.util.List;

public class ClientService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static final Logger LOG = Logger.getLogger(ClientService.class);

    public boolean isClientAlreadyExist(String phoneNumber, String password){
        try (ClientDao dao = daoFactory.createClientDao()) {
            LOG.debug("created ClientDao");
            return dao.isClientExists(phoneNumber, password);
        }
    }

    public Client getClientById(int id){
        try (ClientDao dao = daoFactory.createClientDao()) {
            LOG.debug("created ClientDao");
            return dao.getById(id);
        }
    }

    public boolean isPhoneNumberAlreadyExists(String phoneNumber){
        try (ClientDao dao = daoFactory.createClientDao()) {
            LOG.debug("created ClientDao");
            return dao.isPhoneNumberExists(phoneNumber);
        }
    }

    public boolean isEmailAlreadyExists(String email){
        try (ClientDao dao = daoFactory.createClientDao()) {
            LOG.debug("created ClientDao");
            return dao.isEmailExists(email);
        }
    }

    public void createClientInDatabase(Client client) throws EmailIsAlreadyTaken, PhoneNumberIsAlreadyTaken {
        try (ClientDao dao = daoFactory.createClientDao()) {
            LOG.debug("created ClientDao");
            boolean isTakenEmail = dao.isEmailExists(client.getEmail());
            boolean isTakenPhoneNumber = dao.isPhoneNumberExists(client.getPhoneNumber());
            if (isTakenEmail){
                LOG.debug("e-mail is taken, exception occurred");
                throw new EmailIsAlreadyTaken("This email is already registered");
            }
            if (isTakenPhoneNumber){
                LOG.debug("PhoneNumber is taken, exception occurred");
                throw new PhoneNumberIsAlreadyTaken("This phone number is already registered");
            }
            dao.create(client);
        }
    }

    public Client getClientByPasswordAndPhone(String phoneNumber, String password){
        try(ClientDao dao = daoFactory.createClientDao()){
            LOG.debug("created ClientDao");
            return dao.getClientByPassPhone(phoneNumber, password);
        }
    }

    public List<Client> getAllClients(){
        try (ClientDao dao = daoFactory.createClientDao()) {
            LOG.debug("created ClientDao");
            return dao.findAll();
        }
    }
}
