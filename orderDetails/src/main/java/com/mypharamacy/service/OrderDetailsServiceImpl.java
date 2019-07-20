package com.mypharamacy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypharamacy.entity.Order;
import com.mypharamacy.repository.OrderRepository;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Autowired
    OrderRepository orderRepository;

    public void createOrder(Order order) {
    	orderRepository.save(order);
    }

    public List<Order> getOrder() {
        // TODO Auto-generated method stub
        return (List<Order>) orderRepository.findAll();
    }

    public Order findOrderById(long id) {
        // TODO Auto-generated method stub
    	Optional<Order> order = orderRepository.findById(id);
    	if(order.isPresent()) {
    		return	order.get();
    	}
        return null;
    }

    public Order updateOrder(Order user, long l) {
        // TODO Auto-generated method stub
        return orderRepository.save(user);
    }

    public void deleteOrderById(long id) {
        // TODO Auto-generated method stub
    	orderRepository.deleteById(id);
    }

    public Order updatePartially(Order user, long id) {
        // TODO Auto-generated method stub
    	Order order = findOrderById(id);
    	order.setTotalAmount(order.getTotalAmount());
        return orderRepository.save(order);
    }
}