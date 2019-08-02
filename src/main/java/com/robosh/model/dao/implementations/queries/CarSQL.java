package com.robosh.model.dao.implementations.queries;

import com.robosh.model.dao.implementations.queries.fieldsDatabase.CarFields;

public enum CarSQL {
    READ_BY_ID("SELECT * FROM `" + CarFields.CAR +
            "` WHERE `" + CarFields.ID_CAR + "`=(?)"),

    READ_BY_ID_AND_CAR_TYPE("SELECT * FROM `" + CarFields.CAR +
            "` WHERE `" + CarFields.ID_CAR + "`=(?) AND `" +
            CarFields.CAR_TYPE + "` =(?)"),

    READ_BY_TYPE("SELECT * FROM `" + CarFields.CAR +
            "` WHERE `" + CarFields.CAR_TYPE + "`=(?)"),

    READ_ALL("SELECT * FROM `" + CarFields.CAR + "`"),

    INSERT(""),

    DELETE(""),

    UPDATE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    CarSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
