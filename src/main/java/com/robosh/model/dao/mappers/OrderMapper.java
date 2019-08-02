package com.robosh.model.dao.mappers;

import com.robosh.model.dao.implementations.queries.fieldsDatabase.OrderFields;
import com.robosh.model.entity.Coupon;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.Order;
import com.robosh.model.entity.enums.OrderStatus;
import com.robosh.service.AddressService;
import com.robosh.service.ClientService;
import com.robosh.service.CouponService;
import com.robosh.service.DriverService;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * class that implements Mapper interface
 *
 * @author Orest Shemelyuk
 */
public class OrderMapper implements Mapper<Order> {
    @Override
    public Order getEntity(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        ClientService clientService = new ClientService();
        DriverService driverService = new DriverService();
        AddressService addressService = new AddressService();
        CouponService couponService = new CouponService();
        order.setIdOrder(resultSet.getInt(OrderFields.ID_DRIVER));
        order.setOrderStatus(OrderStatus.valueOf(resultSet.getString(OrderFields.ORDER_STATUS)));
        order.setClient(clientService.getClientById(resultSet.getInt(OrderFields.ID_CLIENT)));

        Driver driver = driverService.getDriverById(resultSet.getInt(OrderFields.ID_DRIVER));
        if (driver.getPersonId() != -1) {
            order.setDriver(driver);
        }
        order.setAddressDeparture(addressService.getAddressById(resultSet.getInt(OrderFields.ID_ADDRESS_DEPARTURES)));
        order.setAddressArrive(addressService.getAddressById(resultSet.getInt(OrderFields.ID_ADDRESS_ARRIVE)));

        Coupon coupon = couponService.getCouponById(resultSet.getInt(OrderFields.ID_COUPON));
        if (coupon.getIdCoupon() != -1) {
            order.setCoupon(coupon);
        }

        order.setCost(resultSet.getInt(OrderFields.COSTS));
        order.setCostWithDiscount(resultSet.getInt(OrderFields.COSTS_WITH_DISCOUNT));
        return order;
    }
}
