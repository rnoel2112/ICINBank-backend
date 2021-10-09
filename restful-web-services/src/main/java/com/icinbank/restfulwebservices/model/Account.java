package com.icinbank.restfulwebservices.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long 	Id;
	private String 	username;
	private String 	accountId;
	private Boolean	isSaving;
	private String 	activity;
	private Date 	transactionDate;
	private Boolean isCredit;
	private long 	amount;
	private long 	balance;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(long id, String username, String accountId, Boolean isSaving, String activity, Date transactionDate,
			Boolean isCredit, long amount, long balance) {
		super();
		Id = id;
		this.username = username;
		this.accountId = accountId;
		this.isSaving = isSaving;
		this.activity = activity;
		this.transactionDate = transactionDate;
		this.isCredit = isCredit;
		this.amount = amount;
		this.balance = balance;
	}
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Boolean getIsSaving() {
		return isSaving;
	}
	public void setIsSaving(Boolean isSaving) {
		this.isSaving = isSaving;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Boolean getIsCredit() {
		return isCredit;
	}
	public void setIsCredit(Boolean isCredit) {
		this.isCredit = isCredit;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [Id=" + Id + ", username=" + username + ", accountId=" + accountId + ", isSaving=" + isSaving
				+ ", activity=" + activity + ", transactionDate=" + transactionDate + ", isCredit=" + isCredit
				+ ", amount=" + amount + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Id ^ (Id >>> 32));
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result + ((activity == null) ? 0 : activity.hashCode());
		result = prime * result + (int) (amount ^ (amount >>> 32));
		result = prime * result + (int) (balance ^ (balance >>> 32));
		result = prime * result + ((isCredit == null) ? 0 : isCredit.hashCode());
		result = prime * result + ((isSaving == null) ? 0 : isSaving.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Id != other.Id)
			return false;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (activity == null) {
			if (other.activity != null)
				return false;
		} else if (!activity.equals(other.activity))
			return false;
		if (amount != other.amount)
			return false;
		if (balance != other.balance)
			return false;
		if (isCredit == null) {
			if (other.isCredit != null)
				return false;
		} else if (!isCredit.equals(other.isCredit))
			return false;
		if (isSaving == null) {
			if (other.isSaving != null)
				return false;
		} else if (!isSaving.equals(other.isSaving))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
		
}
