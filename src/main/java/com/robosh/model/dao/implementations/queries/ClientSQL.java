package com.robosh.model.dao.implementations.queries;

import com.robosh.model.dao.implementations.queries.fieldsDatabase.ClientFields;

public enum ClientSQL {
    READ_BY_ID("SELECT * FROM `" + ClientFields.CLIENT +
            "` WHERE `" + ClientFields.ID_CLIENT + "` =(?)"),

    READ_ALL("SELECT * FROM `" + ClientFields.CLIENT + "`"),

    INSERT("INSERT INTO `" + ClientFields.CLIENT +
            "`(`" + ClientFields.SURNAME + "`, `" + ClientFields.NAME + "`, `" +
            ClientFields.PHONE_NUMBER + "`, `" + ClientFields.EMAIL + "`, `" +
            ClientFields.PASSWORD + "`) VALUES ((?),(?),(?), (?), (?))"),

    READ_BY_EMAIL("SELECT * FROM `" + ClientFields.CLIENT +
            "` WHERE `" + ClientFields.EMAIL + "`=(?)"),

    READ_BY_PHONE_NUMBER("SELECT * FROM `" + ClientFields.CLIENT +
            "` WHERE `" + ClientFields.PHONE_NUMBER + "` =(?)"),

    READ_BY_PHONE_PASSWORD("SELECT * FROM `" + ClientFields.CLIENT +
            "` WHERE `" + ClientFields.PHONE_NUMBER + "` =(?) AND `" +
            ClientFields.PASSWORD + "` =(?)"),

    DELETE(""),
    UPDATE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    ClientSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
