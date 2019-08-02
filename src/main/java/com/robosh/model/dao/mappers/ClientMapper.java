package com.robosh.model.dao.mappers;

import com.robosh.model.dao.implementations.queries.fieldsDatabase.ClientFields;
import com.robosh.model.entity.Client;
import com.robosh.model.entity.enums.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * class that implements Mapper interface
 *
 * @author Orest Shemelyuk
 */
public class ClientMapper implements Mapper<Client> {

    @Override
    public Client getEntity(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setPersonId(resultSet.getInt(ClientFields.ID_CLIENT));
        client.setSurname(resultSet.getString(ClientFields.SURNAME));
        client.setName(resultSet.getString(ClientFields.NAME));
        client.setPhoneNumber(resultSet.getString(ClientFields.PHONE_NUMBER));
        client.setEmail(resultSet.getString(ClientFields.EMAIL));
        client.setPassword(resultSet.getString(ClientFields.PASSWORD));
        client.setRole(Role.CLIENT);
        return client;
    }
}
