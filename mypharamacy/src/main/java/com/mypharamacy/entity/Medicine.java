package com.mypharamacy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="medicine")
public class Medicine implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="medicine_id")
	 private  Integer medicineId;
	@Column(name="medicine_name")
	 private String medicineName;
	@Column(name="amount")
	 private String amount;

	public Integer getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	 
	 

}
