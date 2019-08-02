package com.robosh.model.dao.implementations.queries;

import com.robosh.model.dao.implementations.queries.fieldsDatabase.AddressFields;

public enum AddressSQL {
    READ_BY_ADRESS("SELECT * FROM `" +
            AddressFields.ADDRESS + "` WHERE `" +
            AddressFields.STREET + "` =(?) AND `" +
            AddressFields.HOUSE_NUMBER + "` =(?)"),

    READ_ADDRESS_ID("SELECT `" + AddressFields.ID_ADDRESS +
            "` FROM `" + AddressFields.ADDRESS +
            "` WHERE `" + AddressFields.STREET + "` =(?) AND " +
            AddressFields.HOUSE_NUMBER + "=(?)"),

    READ_BY_ID("SELECT * FROM `" + AddressFields.ADDRESS +
            "` WHERE `" + AddressFields.ID_ADDRESS + "`=(?)"),

    READ_ALL("SELECT * FROM `" + AddressFields.ADDRESS + "`"),
    INSERT(""),
    DELETE(""),
    UPDATE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    AddressSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
