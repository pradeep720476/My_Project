package com.mypharamacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.mypharamacy.entity.Order;
@Transactional
public interface OrderRepository extends JpaRepository<Order, Long> {

	@Modifying
	@Query(value = "update ordersdetails set order_status= ?1 where customer_id = ?2 and order_id =?3 and order_status =?4" , nativeQuery = true)
	public int updateOrderStatus(String status, Long customerId, Long orderId,String oldStatus);
}