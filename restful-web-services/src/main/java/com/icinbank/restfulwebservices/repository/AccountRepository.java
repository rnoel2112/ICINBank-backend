package com.icinbank.restfulwebservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icinbank.restfulwebservices.model.Account;


@Repository
public interface AccountRepository extends JpaRepository <Account, Long> { 
	
	List <Account> getByUsername(String username);
	Account	deleteById (long id);
	Account findById (long id);
	
}
