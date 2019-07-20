package com.mypharamacy.service;

import java.util.List;

import com.mypharamacy.entity.Order;

public interface OrderDetailsService {


	public void createOrder(Order order);
    public List<Order> getOrder();
    public Order findOrderById(long id);
    public Order updateOrder(Order user, long l);
    public void deleteOrderById(long id);
    public Order updatePartially(Order order, long id);
}
