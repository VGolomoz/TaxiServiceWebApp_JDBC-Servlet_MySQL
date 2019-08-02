package com.robosh.model.dao.implementations;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.interfaces.CouponDao;
import com.robosh.model.entity.Coupon;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JdbcCouponDaoTest {

    private CouponDao dao;

    @Before
    public void init() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        dao = daoFactory.createCouponDao();
    }

    @After
    public void after() {
    }

    @Test
    public void shouldReturnCouponById() {
        Coupon actualCoupon = dao.getById(1);
        Coupon couponExpected = new Coupon();
        couponExpected.setIdCoupon(1);
        couponExpected.setDiscount(20);
        couponExpected.setCouponName("AZAZ");
        assertEquals(couponExpected, actualCoupon);
    }

    @Test
    public void shouldNotReturnCouponById() {
        Coupon actualCoupon = dao.getById(0);
        Coupon couponExpected = new Coupon();
        couponExpected.setIdCoupon(1);
        couponExpected.setDiscount(20);
        couponExpected.setCouponName("AZAZ");
        assertNotEquals(couponExpected, actualCoupon);
    }

    @Test
    public void shouldReturnCouponByCouponName() {
        Coupon actualCoupon = dao.readByCouponName("AZAZ");
        Coupon couponExpected = new Coupon();
        couponExpected.setIdCoupon(1);
        couponExpected.setDiscount(20);
        couponExpected.setCouponName("AZAZ");
        assertEquals(couponExpected, actualCoupon);
    }


    @Test
    public void shouldNotReturnCouponByCouponName() {
        Coupon actualCoupon = dao.readByCouponName("AZAZA");
        Coupon couponExpected = new Coupon();
        couponExpected.setIdCoupon(1);
        couponExpected.setDiscount(20);
        couponExpected.setCouponName("AZAZ");
        assertNotEquals(couponExpected, actualCoupon);
    }
}