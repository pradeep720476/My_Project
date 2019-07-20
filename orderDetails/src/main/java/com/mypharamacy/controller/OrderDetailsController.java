package com.mypharamacy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mypharamacy.entity.Order;
import com.mypharamacy.exception.OrderNotFoundException;
import com.mypharamacy.service.OrderDetailsService;
import com.mypharamacy.service.OrderDetailsServiceImpl;

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailsController {
	
	    @Autowired
	    OrderDetailsService orderService;

	    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Order> getUserById(@PathVariable("id") long id) {
	        System.out.println("Fetching User with id " + id);
	        Order user = orderService.findOrderById(id);
	        if (user == null) {
	            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Order>(user, HttpStatus.OK);
	    }

	    @PostMapping(value="/create",headers="Accept=application/json")
	    public ResponseEntity<Void> createUser(@RequestBody Order order, UriComponentsBuilder ucBuilder){
	        //System.out.println("Creating Order "+order.getOrderId());
	        orderService.createOrder(order);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(order.getOrderid()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }

	    @GetMapping(value="/get", headers="Accept=application/json")
	    public List<Order> getAllUser() {
	        List<Order> tasks=orderService.getOrder();
	        return tasks;

	    }

	    @PutMapping(value="/update", headers="Accept=application/json")
	    public ResponseEntity<String> updateUser(@RequestBody Order currentOrder)
	    {
	        System.out.println("sd");
	        Order order = orderService.findOrderById(currentOrder.getOrderid());
	        if (order==null) {
	            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	        }
	        orderService.updateOrder(currentOrder, currentOrder.getOrderid());
	        return new ResponseEntity<String>(HttpStatus.OK);
	    }

	    @DeleteMapping(value="/{id}", headers ="Accept=application/json")
	    public ResponseEntity<Order> deleteOrder(@PathVariable("id") long id){
	        Order order = orderService.findOrderById(id);
	        if (order == null) {
	            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
	        }
	        orderService.deleteOrderById(id);
	        return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
	    }

	    @PatchMapping(value="/{id}", headers="Accept=application/json")
	    public ResponseEntity<Order> updateUserPartially(@PathVariable("id") long id, @RequestBody Order currentOrder){
	        Order order = orderService.findOrderById(id);
	        if(order ==null){
	            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
	        }
	        Order orderUpdatePartially = orderService.updatePartially(currentOrder, id);
	        return new ResponseEntity<Order>(orderUpdatePartially, HttpStatus.OK);
	    }
	}