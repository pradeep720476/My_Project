package com.mypharamacy.service;

import java.util.List;

import com.mypharamacy.entity.Pharmacy;

public interface PharmacyDetailsService {


	public void createPharmacist(Pharmacy order);
    public List<Pharmacy> getPharmacist();
    public Pharmacy findPharmacistById(long id);
    public Pharmacy updatePharmacist(Pharmacy user, long l);
    public void deletePharmacistById(long id);
    public Pharmacy updatePartially(Pharmacy order, long id);
}
