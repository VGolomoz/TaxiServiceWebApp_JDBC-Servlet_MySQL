package com.robosh.model.dao.interfaces;

import com.robosh.model.entity.Order;
import com.robosh.model.entity.enums.OrderStatus;

import java.util.List;

public interface OrderDao extends Dao<Order> {
    List<Order> getAllOrdersByDriverId(int idDriver, int row, int limit);

    void createWithoutCoupon(Order order);

    long getCountOrders(int idDriver);

    boolean updateOrderStatus(int idOrder, OrderStatus orderStatus);

    boolean isCorrespondOrderAndDriver(int idOrder, int idDriver);
}
