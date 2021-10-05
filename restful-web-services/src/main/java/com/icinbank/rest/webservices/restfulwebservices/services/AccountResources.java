package com.icinbank.rest.webservices.restfulwebservices.services;

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

import com.icinbank.rest.webservices.restfulwebservices.model.Account;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AccountResources {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/users/{username}/accountdetails")
	public List <Account> getAllAccount(@PathVariable String username){
		return accountService.findAll();
	}
	
	@GetMapping("/users/{username}/useraccountdetails")
	public List<Account> getAccounts(@PathVariable String username){
		
		return accountService.findAccount(username);
	}
	

	@GetMapping("/users/{username}/accountinfo")
	public ResponseEntity <Account> getAccoountInfo(@PathVariable String username){
			
		Account account =  accountService.accountInfo(username);
		if (account != null) {
			System.out.println ("Account Info:" + account.toString());
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
		Account accountUpdated = accountService.save(account);
		
		return new ResponseEntity<Account>(accountUpdated, HttpStatus.OK);
	}
	

	@PostMapping("/users/{username}/transfer")
	public ResponseEntity<Account> transfer(@PathVariable String username,
			@RequestBody List<Account> accounts){
	
		//for (Account aaccount : accounts){
		//	 accountUpdated = accountService.save(aaccount);
		//}
		
		Account accountUpdated = (Account) accounts.get(1);
		Account missing = accountService.accountInfo(accountUpdated.getUsername());
		accountUpdated.setBalance(missing.getBalance()+accountUpdated.getAmount());
		System.out.println("Saving..."+ accountUpdated.toString());
		
		accountUpdated = accountService.save(accountUpdated);
		
		
		accountUpdated = (Account) accounts.get(0);
		
		System.out.println("Saving..."+ accountUpdated.toString());
		
		accountUpdated = accountService.save(accountUpdated);
	
		return new ResponseEntity<Account>(accountUpdated, HttpStatus.OK);
	}
	
}
