package com.mypharamacy.repository;

import com.mypharamacy.entity.Presciption;
import com.mypharamacy.entity.User;

public interface CustomerRepository {
	public int upload(Presciption presciption);

	public User save(User pUser);

}
