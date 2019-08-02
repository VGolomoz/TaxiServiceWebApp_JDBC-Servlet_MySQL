package com.robosh.web.command.account.client;


import com.robosh.myUtils.CookiesUtils;
import com.robosh.myUtils.LoginedUserUtils;
import com.robosh.myUtils.PriceVoyageUtils;
import com.robosh.myUtils.TimeWaitTaxiUtil;
import com.robosh.web.command.Command;
import com.robosh.model.entity.*;
import com.robosh.model.entity.enums.DriverStatus;
import com.robosh.service.AddressService;
import com.robosh.service.CouponService;
import com.robosh.service.DriverService;
import com.robosh.service.OrderService;
import com.robosh.web.command.RoutesJSP;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.robosh.web.command.PathCommand.*;

/**
 * class that takes parameter from order and process them
 *
 * @author Orest Shemelyuk
 */
public class EnterOrderCommand implements Command {
    private static final String ADDRESS_DEPARTURE_PARAMETER = "addressDeparture";
    private static final String ADDRESS_ARRIVE_PARAMETER = "addressArrive";
    private static final String CAR_TYPE_PARAMETER = "carType";
    private static final String COUPON_PARAMETER = "coupon";
    private static final String NO_SUCH_CAR = "?noSuitableCarType=true";
    private static final String SAME_ADDRESS = "?sameAddress=true";
    private static final ClientOrderCommand clientOrder = new ClientOrderCommand();
    private final Logger LOGGER = Logger.getLogger(EnterOrderCommand.class);

    private OrderService orderService;
    private DriverService driverService;
    private AddressService addressService;
    private CouponService couponService;

    public EnterOrderCommand(OrderService orderService, DriverService driverService,
                             AddressService addressService, CouponService couponService) {
        this.orderService = orderService;
        this.driverService = driverService;
        this.addressService = addressService;
        this.couponService = couponService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String addressDepartureStr = request.getParameter(ADDRESS_DEPARTURE_PARAMETER);
        final String addressArriveStr = request.getParameter(ADDRESS_ARRIVE_PARAMETER);
        final String carType = request.getParameter(CAR_TYPE_PARAMETER);
        final String couponStr = request.getParameter(COUPON_PARAMETER);

        if (isNotSameAddress(addressDepartureStr, addressArriveStr)) {
            LOGGER.info("is not same address");
            Driver driver = driverService.getDriverByCarTypeAndDriverStatus(DriverStatus.FREE, carType);
            if (driver != null) {
                LOGGER.info("driver is free");
                bookedDriver(driver);
                Client loginedClient = (Client) LoginedUserUtils.getLoginedUser(request.getSession());
                Address addressDeparture = addressService.getAdressByAdressString(addressDepartureStr);
                Address addressArrive = addressService.getAdressByAdressString(addressArriveStr);
                Coupon coupon = couponService.getCouponByName(couponStr);
                int costs = PriceVoyageUtils.getPriceDependDistance(addressArrive, addressDeparture);
                int costWithDiscount = PriceVoyageUtils.getPriceWithCoupon(costs, coupon);
                orderService.createOrderInDB(loginedClient, driver, addressDeparture, addressArrive,
                        coupon, costs, costWithDiscount);
                int timeWait = TimeWaitTaxiUtil.getTimeWait();
                CookiesUtils.addCookies(response, driver, costWithDiscount, timeWait);

                String contextAndServletPath = request.getContextPath() + request.getServletPath();
                LOGGER.info("show order");
                return REDIRECT + contextAndServletPath + SHOW_CLIENT_ORDER;
            } else {
                LOGGER.info("no such car");
                return clientOrder.execute(request,response)+ NO_SUCH_CAR;
            }
        } else {
            LOGGER.info("choosed same address");
            return clientOrder.execute(request, response) + SAME_ADDRESS;
        }
    }

    private void bookedDriver(Driver driver) {
        driver.setDriverStatus(DriverStatus.BOOKED);
        driverService.updateDriverStatus(driver);
    }

    //check if address is not same
    private boolean isNotSameAddress(String addressDeparture, String addressArrive) {
        return !addressArrive.equals(addressDeparture);
    }

}
