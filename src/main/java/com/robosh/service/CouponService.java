package com.robosh.service;

import com.robosh.model.dao.interfaces.CouponDao;
import com.robosh.model.dao.DaoFactory;
import com.robosh.model.entity.Coupon;
import org.apache.log4j.Logger;

import java.util.List;

public class CouponService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static final Logger LOG = Logger.getLogger(CarService.class);

    public Coupon getCouponById(int id) {
        try (CouponDao dao = daoFactory.createCouponDao()) {
            LOG.debug("created CouponDao");
            return dao.getById(id);
        }
    }

    public List<Coupon> getAllCoupons() {
        try (CouponDao dao = daoFactory.createCouponDao()){
            LOG.debug("created CouponDao");
            return dao.findAll();
        }
    }

    public Coupon getCouponByName(String couponName){
        try (CouponDao dao = daoFactory.createCouponDao()) {
            LOG.debug("created CouponDao");
            return dao.readByCouponName(couponName);
        }
    }
}
