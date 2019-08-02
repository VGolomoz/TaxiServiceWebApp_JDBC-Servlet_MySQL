package com.robosh.model.dao.implementations.queries;

import com.robosh.model.dao.implementations.queries.fieldsDatabase.OrderFields;

public enum OrderSQL {
    READ_BY_ID("SELECT * FROM `" + OrderFields.ORDER +
            "` WHERE `" + OrderFields.ORDER_ID + "` =(?)"),

    READ_BY_ID_DRIVER("SELECT * FROM `" + OrderFields.ORDER +
            "` WHERE `" + OrderFields.ID_DRIVER + "` =(?)"),

    READ_BY_ID_DRIVER_WITH_LIMIT("SELECT * FROM `" + OrderFields.ORDER +
            "` WHERE `" + OrderFields.ID_DRIVER + "` =(?) ORDER BY " + OrderFields.ORDER_ID + " DESC limit ?, ?"),

    READ_ALL("SELECT * FROM `" + OrderFields.ORDER + "`"),

    INSERT("INSERT INTO `" + OrderFields.ORDER + "`(`" +
            OrderFields.ORDER_STATUS + "`, `" + OrderFields.ID_CLIENT + "`, `" +
            OrderFields.ID_DRIVER + "`, `" + OrderFields.ID_ADDRESS_DEPARTURES + "`, `" +
            OrderFields.ID_ADDRESS_ARRIVE + "`, `" + OrderFields.ID_COUPON + "`, `" +
            OrderFields.COSTS + "`, `" + OrderFields.COSTS_WITH_DISCOUNT + "`)" +
            " VALUES ((?), (?), (?), (?), (?), (?), (?), (?))"),

    INSERT_WITHOUT_COUPON("INSERT INTO `" + OrderFields.ORDER +
            "` (`" + OrderFields.ORDER_STATUS + "`, `" + OrderFields.ID_CLIENT + "`, `" +
            OrderFields.ID_DRIVER + "`, `" + OrderFields.ID_ADDRESS_DEPARTURES + "`, `" +
            OrderFields.ID_ADDRESS_ARRIVE + "`, `" + OrderFields.COSTS + "`, `" +
            OrderFields.COSTS_WITH_DISCOUNT + "`) " +
            "VALUES ((?), (?), (?), (?), (?), (?), (?))"),

    UPDATE("UPDATE `" + OrderFields.ORDER +
            "` SET `" + OrderFields.ORDER_STATUS + "` = (?) WHERE `" +
            OrderFields.ORDER_ID + "` = (?)"),

    IS_SUCH_VOYAGE("SELECT * FROM `" + OrderFields.ORDER +
            "` WHERE `" + OrderFields.ORDER_ID + "` = (?) AND `" +
            OrderFields.ID_DRIVER + "` = (?) AND `" + OrderFields.ORDER_STATUS + "` = (?)"),

    GET_COUNT_ORDERS("SELECT count(*) FROM `" + OrderFields.ORDER +
            "` WHERE `" + OrderFields.ID_DRIVER + "` = (?)"),

    DELETE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    OrderSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
