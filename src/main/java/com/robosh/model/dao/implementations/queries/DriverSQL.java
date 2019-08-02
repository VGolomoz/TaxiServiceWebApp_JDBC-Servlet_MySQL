package com.robosh.model.dao.implementations.queries;

import com.robosh.model.dao.implementations.queries.fieldsDatabase.CarFields;
import com.robosh.model.dao.implementations.queries.fieldsDatabase.DriverFields;

public enum DriverSQL {
    FIND_DRIVER_BY_CAR_TYPE_AND_STATUS("SELECT * FROM `" + DriverFields.DRIVER + "`, `" +
            CarFields.CAR + "` WHERE `" + DriverFields.DRIVER_STATUS + "`=(?) AND `" +
            DriverFields.DRIVER + "`.`" + DriverFields.ID_CAR_DRIVER + "` = `" +
            CarFields.CAR + "`.`" + CarFields.ID_CAR + "` AND `" + CarFields.CAR_TYPE + "`=(?) limit 1;"),

    CHECK_STATUS("SELECT * FROM `" + DriverFields.DRIVER +
            "` WHERE `" + DriverFields.DRIVER_STATUS + "` =(?)"),

    READ_BY_PHONE_AND_PASSWORD("SELECT * FROM `" + DriverFields.DRIVER +
            "` WHERE `" + DriverFields.PHONE_NUMBER + "` = (?) AND `" +
            DriverFields.PASSWORD + "` = (?)"),

    READ_BY_ID("SELECT * FROM `" + DriverFields.DRIVER +
            "` WHERE `" + DriverFields.ID_DRIVER + "` =(?)"),

    READ_ALL("SELECT * FROM `" + DriverFields.DRIVER + "`"),

    UPDATE("UPDATE `" + DriverFields.DRIVER +
            "` SET `" + DriverFields.DRIVER_STATUS + "`=(?) WHERE `" +
            DriverFields.ID_DRIVER + "` = (?)"),

    INSERT(""),

    DELETE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    DriverSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
