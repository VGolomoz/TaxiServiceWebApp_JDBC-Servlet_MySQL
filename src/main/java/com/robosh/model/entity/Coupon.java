package com.robosh.model.entity;

import java.util.Objects;

public class Coupon {
    private int idCoupon;
    private String couponName;
    private int discount;

    public int getIdCoupon() {
        return idCoupon;
    }

    public void setIdCoupon(int idCoupon) {
        this.idCoupon = idCoupon;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "idCoupon=" + idCoupon +
                ", couponName='" + couponName + '\'' +
                ", discount=" + discount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coupon)) return false;
        Coupon coupon = (Coupon) o;
        return idCoupon == coupon.idCoupon &&
                discount == coupon.discount &&
                Objects.equals(couponName, coupon.couponName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCoupon, couponName, discount);
    }
}
