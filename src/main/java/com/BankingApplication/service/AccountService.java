package com.BankingApplication.service;

import java.util.List;

import com.BankingApplication.dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(AccountDto accountdto);

	AccountDto getAccountById(Long Id);
	
	AccountDto deposit(Long id, double amount);
	
	AccountDto withDraw(Long id, double amount);
	
	List<AccountDto> getAllAccount();
	
	
	void deleteAccount(Long id);

}
