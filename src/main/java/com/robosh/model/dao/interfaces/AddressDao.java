package com.robosh.model.dao.interfaces;

import com.robosh.model.entity.Address;

public interface AddressDao extends Dao<Address> {
    boolean checkAddressExist(String street, String numberHouse);

    int getAddressId(String street, String numberHouse);

    Address getAddressByStreetNumberHouse(String street, String numberHouse);
}
