package com.icinbank.restfulwebservices.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.icinbank.restfulwebservices.model.Account;

@Service
public class AccountService {
	
	private static List < Account> accounts = new ArrayList<Account>();
	private static int idCounter = 0;

		
	static {
		accounts.add (new Account(++idCounter,"simplilearn","Acc-001",true,"Credit", new Date(),false, 5, 10));
		accounts.add (new Account(++idCounter,"user2","Acc-002",true,"Withdraw", new Date(),true, 1, 14));
		accounts.add (new Account(++idCounter,"user3","Acc-003",true,"Deposit", new Date(),false, 1, 15));
	}

	public List <Account> findAll(){
		return accounts;
	}
	
	public List <Account> findAccount(String username){
		
		List < Account> useAccount = new ArrayList<Account>();
		
		for (Account account:accounts) {
			if (account.getUsername().equals(username)) {
				useAccount.add(account);
			}
		}
		return useAccount;	
	}
	
	
	public Account accountInfo(String username){
			
		for (Account account:accounts) {
			if (account.getUsername().equals(username)) {
				return account;	
			}
		}
		return null;	
	}
	
	public Account save( Account account) {
		if(account.getId() == -1) {
			account.setId(++idCounter);
			accounts.add(account);			
		}else {
			deleteById (account.getId());
			accounts.add(account);
		}
		return account;
	}
	
	public Account deleteById ( long id) {
		
		Account account = findById (id);
		if (account ==null) return null;
		
		if (accounts.remove(account)) {
			return account;	
		}
		return null;
	}
	
	public Account findById (long id) {
		
		for (Account account:accounts) {
			if (account.getId() == id) {
				return account;
			}
		}
		return null;
	}
	
	
	
}
