package com.robosh.myUtils;

import com.robosh.model.entity.Address;
import com.robosh.model.entity.Coupon;

/**
 * class that calculate price of voyage
 *
 * @author Orest Shemelyuk
 */
public class PriceVoyageUtils {
    private static final double START_PRICE = 30.0;

    private PriceVoyageUtils() {
    }

    public static int getPriceDependDistance(Address addressArrive, Address addressDeparture) {
        double arriveStreetPrice = getStreetPrice(addressArrive.getStreet());
        double departureStreetPrice = getStreetPrice(addressDeparture.getStreet());
        double arriveHouseNumberPrice = getHouseNumberPrice(addressArrive.getHouseNumber());
        double departureHouseNumberPrice = getHouseNumberPrice(addressDeparture.getHouseNumber());
        return (int) (START_PRICE + arriveStreetPrice + departureStreetPrice +
                arriveHouseNumberPrice + departureHouseNumberPrice + getPriceWeather());
    }

    public static int getPriceWithCoupon(int price, Coupon coupon) {
        int priceWithCoupon = calculatePriceWithCoupon(price, coupon);
        return loyaltyProgram(priceWithCoupon);
    }

    private static double getHouseNumberPrice(String houseNumber) {
        if (houseNumber.contains("/")) {
            houseNumber = houseNumber.replace("/", ".");
        }
        return new Double(houseNumber);
    }

    private static double getStreetPrice(String street) {
        return (double) street.charAt(0) / 10.0;
    }

    /**
     * calculate price depending weather in the city
     *
     * @return
     */
    private static int getPriceWeather() {
        return (int) (Math.random() * 100);
    }

    private static int calculatePriceWithCoupon(int price, Coupon coupon) {
        if (coupon.getIdCoupon() != -1) {
            double discountPercents = coupon.getDiscount();
            return (int) (price - price * (discountPercents / 100));
        } else return price;
    }

    private static int loyaltyProgram(double price) {
        if (price > 200) {
            price = price - price * 0.2;
        }
        return (int) price;
    }
}
