package com.robosh.model.dao.mappers;

import com.robosh.model.dao.implementations.queries.fieldsDatabase.AddressFields;
import com.robosh.model.entity.Address;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * class that implements Mapper interface
 *
 * @author Orest Shemelyuk
 */
public class AddressMapper implements Mapper<Address> {

    /**
     * getEntity from database
     *
     * @param resultSet
     * @return Address
     * @throws SQLException
     */
    @Override
    public Address getEntity(ResultSet resultSet) throws SQLException {
        Address address = new Address();
        address.setIdAddress(resultSet.getInt(AddressFields.ID_ADDRESS));
        address.setStreet(resultSet.getString(AddressFields.STREET));
        address.setHouseNumber(resultSet.getString(AddressFields.HOUSE_NUMBER));
        return address;
    }
}
