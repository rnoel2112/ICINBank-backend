package com.icinbank.restfulwebservices.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.icinbank.restfulwebservices.model.Account;

@Service
public interface AccountService {
	
	List 	<Account> 	findAll();
	List 	<Account> 	getByUsername(String username);
	Account 			save(Account account);
	Account 			deleteById (long id);
	Account 			findById (long id);
}
