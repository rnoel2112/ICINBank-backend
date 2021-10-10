package com.icinbank.restfulwebservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinbank.restfulwebservices.model.Account;
import com.icinbank.restfulwebservices.repository.AccountRepository;



@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired 
	private AccountRepository aAccountRepository;

	
	@Override
	public List<Account> findAll() {
			return this.aAccountRepository.findAll();		
	}

	@Override
	public Account save(Account aAcount) {	
			return this.aAccountRepository.save(aAcount);	
	}

	
	@Override
	public List<Account> getByUsername(String username) {
		return this.aAccountRepository.getByUsername(username);
	}

	public Account accountInfo(String username){
		
		return findFirstByUsernameOrderByTransactionDateDesc(username);

//		List<Account> accounts = this.aAccountRepository.getByUsername(username);
//		// we just need any one account
//		for (Account account:accounts) {
//			return account;	
//		}
//		return null;	
	}
	
	public Account saveWithBalanceUpdate(Account account, String username){
		
		Account accountUpdated = this.findFirstByUsernameOrderByTransactionDateDesc(username);
		
		System.out.println("max by transact time"+accountUpdated.toString());
		if (account.getIsCredit()) {
			account.setBalance(accountUpdated.getBalance()-account.getAmount());
		}else {
			account.setBalance(accountUpdated.getBalance()+account.getAmount());
		}

		return this.save(account);
	}


	@Override
	public Account deleteById(long id) {
		return this.aAccountRepository.deleteById(id);
	}

	@Override
	public Account findById(long id) {
		return this.aAccountRepository.findById(id);
	}

	@Override
	public Account findFirstByUsernameOrderByTransactionDateDesc(String username) {
		
		return this.aAccountRepository.findFirstByUsernameOrderByTransactionDateDesc(username);
	
	}

	@Override
	public List<Account> findByUsernameOrderByTransactionDateDesc(String username) {
		return this.aAccountRepository.findByUsernameOrderByTransactionDateDesc(username);
	}
	
}
