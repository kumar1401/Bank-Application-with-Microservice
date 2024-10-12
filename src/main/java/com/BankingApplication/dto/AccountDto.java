package com.BankingApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
	
	private Long Id;
	private String accountHolderName;
	private double balance;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "AccountDto [Id=" + Id + ", accountHolderName=" + accountHolderName + ", balance=" + balance + "]";
	}
	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountDto(Long id, String accountHolderName, double balance) {
		super();
		Id = id;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}
	
	
}
