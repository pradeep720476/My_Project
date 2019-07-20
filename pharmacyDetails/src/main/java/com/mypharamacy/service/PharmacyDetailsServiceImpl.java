package com.mypharamacy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypharamacy.entity.Pharmacy;
import com.mypharamacy.repository.PharmacyRepository;

@Service
public class PharmacyDetailsServiceImpl implements PharmacyDetailsService {
    @Autowired
    PharmacyRepository pharmacyRepository;

    public void createPharmacist(Pharmacy order) {
    	pharmacyRepository.save(order);
    }

    public List<Pharmacy> getPharmacist() {
        // TODO Auto-generated method stub
        return (List<Pharmacy>) pharmacyRepository.findAll();
    }

    public Pharmacy findPharmacistById(long id) {
        // TODO Auto-generated method stub
    	Optional<Pharmacy> order = pharmacyRepository.findById(id);
    	if(order.isPresent()) {
    		return	order.get();
    	}
        return null;
    }

    public Pharmacy updatePharmacist(Pharmacy pharmacy, long l) {
        // TODO Auto-generated method stub
        return pharmacyRepository.save(pharmacy);
    }

    public void deletePharmacistById(long id) {
        // TODO Auto-generated method stub
    	pharmacyRepository.deleteById(id);
    }

    public Pharmacy updatePartially(Pharmacy user, long id) {
        // TODO Auto-generated method stub
    	Pharmacy pharmacy = findPharmacistById(id);
    	pharmacy.setPhoneNo(pharmacy.getPhoneNo());
        return pharmacyRepository.save(pharmacy);
    }
}