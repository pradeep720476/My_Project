package com.mypharamacy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypharamacy.entity.Presciption;
import com.mypharamacy.entity.User;
@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository{
	@Autowired
	private RegisterUserRepository registerUserRepository;

	@Override
	public int upload(Presciption presciption) {


		return 0; //registerUserRepository.save(presciption);
	}

	@Override
	public User save(User pUser) {
		// TODO Auto-generated method stub
		return registerUserRepository.save(pUser);
	}

}
