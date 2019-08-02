package com.robosh.model.dao.mappers;

import com.robosh.model.dao.implementations.queries.fieldsDatabase.CouponFields;
import com.robosh.model.entity.Coupon;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * class that implements Mapper interface
 *
 * @author Orest Shemelyuk
 */
public class CouponMapper implements Mapper<Coupon> {
    @Override
    public Coupon getEntity(ResultSet resultSet) throws SQLException {
        Coupon coupon = new Coupon();
        coupon.setIdCoupon(resultSet.getInt(CouponFields.ID_COUPON));
        coupon.setCouponName(resultSet.getString(CouponFields.COUPON_NAME));
        coupon.setDiscount(resultSet.getInt(CouponFields.COUPON_DISCOUNT));
        return coupon;
    }
}
