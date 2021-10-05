package com.icinbank.rest.webservices.restfulwebservices.model;

import java.util.Date;

public class UserProfile {
	
	private long 	Id ;
	private String 	username;
	private String 	nationalId;
	private Date 	dateOfBirth;
	private String 	password;
	private Boolean	bankingRestriction;
	private Boolean	checkBookRequest;	
	
	public UserProfile(long id, String username, String nationalId, Date dateOfBirth, String password,
			Boolean bankingRestriction, Boolean checkBookRequest) {
		super();
		Id = id;
		this.username = username;
		this.nationalId = nationalId;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.bankingRestriction = bankingRestriction;
		this.checkBookRequest = checkBookRequest;
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
	public String getNationalId() {
		return nationalId;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getBankingRestriction() {
		return bankingRestriction;
	}
	public void setBankingRestriction(Boolean bankingRestriction) {
		this.bankingRestriction = bankingRestriction;
	}
	public Boolean getCheckBookRequest() {
		return checkBookRequest;
	}
	public void setCheckBookRequest(Boolean checkBookRequest) {
		this.checkBookRequest = checkBookRequest;
	}
	@Override
	public String toString() {
		return "UserProfile [Id=" + Id + ", username=" + username + ", nationalId=" + nationalId + ", dateOfBirth="
				+ dateOfBirth + ", password=" + password + ", bankingRestriction=" + bankingRestriction
				+ ", checkBookRequest=" + checkBookRequest + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Id ^ (Id >>> 32));
		result = prime * result + ((bankingRestriction == null) ? 0 : bankingRestriction.hashCode());
		result = prime * result + ((checkBookRequest == null) ? 0 : checkBookRequest.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((nationalId == null) ? 0 : nationalId.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		UserProfile other = (UserProfile) obj;
		if (Id != other.Id)
			return false;
		if (bankingRestriction == null) {
			if (other.bankingRestriction != null)
				return false;
		} else if (!bankingRestriction.equals(other.bankingRestriction))
			return false;
		if (checkBookRequest == null) {
			if (other.checkBookRequest != null)
				return false;
		} else if (!checkBookRequest.equals(other.checkBookRequest))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (nationalId == null) {
			if (other.nationalId != null)
				return false;
		} else if (!nationalId.equals(other.nationalId))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
	

}
