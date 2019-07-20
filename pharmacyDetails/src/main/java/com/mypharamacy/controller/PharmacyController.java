package com.mypharamacy.controller;

import java.util.List;

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

import com.mypharamacy.entity.Pharmacy;
import com.mypharamacy.service.PharmacyDetailsService;

@RestController
@RequestMapping("/vendorRegistration")
public class PharmacyController {
	
	    @Autowired
	    PharmacyDetailsService pharmacyService;

	    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Pharmacy> getUserById(@PathVariable("id") long id) {
	        System.out.println("Fetching User with id " + id);
	        Pharmacy user = pharmacyService.findPharmacistById(id);
	        if (user == null) {
	            return new ResponseEntity<Pharmacy>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Pharmacy>(user, HttpStatus.OK);
	    }

	    @PostMapping(value="/create",headers="Accept=application/json")
	    public ResponseEntity<Void> createUser(@RequestBody Pharmacy pharmacy, UriComponentsBuilder ucBuilder){
	    	pharmacyService.createPharmacist(pharmacy);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(pharmacy.getPharmacyId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }

	    @GetMapping(value="/get", headers="Accept=application/json")
	    public List<Pharmacy> getAllUser() {
	        List<Pharmacy> tasks=pharmacyService.getPharmacist();
	        return tasks;

	    }

	    @PutMapping(value="/update", headers="Accept=application/json")
	    public ResponseEntity<String> updateUser(@RequestBody Pharmacy pharmacy)
	    {
	        System.out.println("sd");
	        Pharmacy order = pharmacyService.findPharmacistById(pharmacy.getPharmacyId());
	        if (order==null) {
	            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	        }
	        pharmacyService.updatePharmacist(pharmacy, pharmacy.getPharmacyId());
	        return new ResponseEntity<String>(HttpStatus.OK);
	    }

	    @DeleteMapping(value="/{id}", headers ="Accept=application/json")
	    public ResponseEntity<Pharmacy> deleteOrder(@PathVariable("id") long id){
	        Pharmacy order = pharmacyService.findPharmacistById(id);
	        if (order == null) {
	            return new ResponseEntity<Pharmacy>(HttpStatus.NOT_FOUND);
	        }
	        pharmacyService.deletePharmacistById(id);
	        return new ResponseEntity<Pharmacy>(HttpStatus.NO_CONTENT);
	    }

	    @PatchMapping(value="/{id}", headers="Accept=application/json")
	    public ResponseEntity<Pharmacy> updateUserPartially(@PathVariable("id") long id, @RequestBody Pharmacy currentOrder){
	        Pharmacy order = pharmacyService.findPharmacistById(id);
	        if(order ==null){
	            return new ResponseEntity<Pharmacy>(HttpStatus.NOT_FOUND);
	        }
	        Pharmacy orderUpdatePartially = pharmacyService.updatePartially(currentOrder, id);
	        return new ResponseEntity<Pharmacy>(orderUpdatePartially, HttpStatus.OK);
	    }
	}