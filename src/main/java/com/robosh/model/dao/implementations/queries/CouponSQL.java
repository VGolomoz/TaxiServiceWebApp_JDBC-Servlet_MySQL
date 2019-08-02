package com.robosh.model.dao.implementations.queries;

import com.robosh.model.dao.implementations.queries.fieldsDatabase.CouponFields;

public enum CouponSQL {
    READ_BY_ID("SELECT * FROM `" + CouponFields.COUPON +
            "` WHERE `" + CouponFields.ID_COUPON + "` =(?)"),

    READ_BY_COUPON("SELECT * FROM `" + CouponFields.COUPON +
            "` WHERE `" + CouponFields.COUPON_NAME + "` =(?)"),

    READ_ALL("SELECT * FROM `" + CouponFields.COUPON + "`"),

    INSERT(""),
    DELETE(""),
    UPDATE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    CouponSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
