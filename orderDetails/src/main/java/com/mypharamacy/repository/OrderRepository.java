package com.mypharamacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.mypharamacy.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}