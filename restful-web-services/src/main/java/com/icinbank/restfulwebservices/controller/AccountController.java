package com.icinbank.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icinbank.restfulwebservices.model.Account;
import com.icinbank.restfulwebservices.services.AccountServiceImpl;

//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins="http://3.1.222.123:4200")
@RestController
public class AccountController {
	
	@Autowired
	private AccountServiceImpl accountService;
	
	@GetMapping("/users/{username}/accountdetails")
	public List <Account> getAllAccount(@PathVariable String username){
		return accountService.findAll();
	}
	
	@GetMapping("/users/{username}/useraccountdetails")
	public List<Account> getAccounts(@PathVariable String username){
		
		//return accountService.getByUsername(username);
		return accountService.findByUsernameOrderByTransactionDateDesc(username);
	}
	

	@GetMapping("/users/{username}/accountinfo")
	public ResponseEntity <Account> accountInfo(@PathVariable String username){
			
		Account account =  accountService.accountInfo(username);
		if (account != null) {
			System.out.println ("Account Info:" + account.toString());
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/users/{username}/accountBalance")
	public ResponseEntity <Account> accountBalance(@PathVariable String username){
			
		Account account = accountService.findFirstByUsernameOrderByTransactionDateDesc(username);
		if (account != null) {
			System.out.println ("Account Balance:" + account.toString());
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}
		
		return ResponseEntity.noContent().build();
	}
	
	
	@DeleteMapping("/users/{username}/accountdetail/{id}")
	public ResponseEntity<Void> deleteAccount(@PathVariable String username, @PathVariable long id){
		Account account = accountService.deleteById(id); 
		if (account != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.noContent().build();
	}
	

	@PostMapping("/users/{username}/deposit")
	public ResponseEntity<Account> deposit(@PathVariable String username,
			@RequestBody Account account){
		Account accountUpdated = accountService.saveWithBalanceUpdate(account,username);
		return new ResponseEntity<Account>(accountUpdated, HttpStatus.OK);
	}
	

	@PostMapping("/users/{username}/transfer")
	public ResponseEntity<Account> transfer(@PathVariable String username,
			@RequestBody List<Account> accounts){
		
		Account accountUpdated = (Account) accounts.get(1);
		accountService.saveWithBalanceUpdate(accountUpdated,accountUpdated.getUsername());
		
		accountUpdated = (Account) accounts.get(0);
		accountService.saveWithBalanceUpdate(accountUpdated,accountUpdated.getUsername());
	
		return new ResponseEntity<Account>(accountUpdated, HttpStatus.OK);
	}
	
}
