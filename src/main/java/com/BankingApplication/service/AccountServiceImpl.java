package com.BankingApplication.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankingApplication.dto.AccountDto;
import com.BankingApplication.entity.Account;
import com.BankingApplication.mapper.AccountMapper;
import com.BankingApplication.repository.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {

	// with @Autowired
	@Autowired
	private AccountRepo accountRepo;

	// without @Autowired
	public AccountServiceImpl(AccountRepo accountRepo) {
		super();
		this.accountRepo = accountRepo;
	}

	@Override
	public AccountDto createAccount(AccountDto accountdto) {
		Account account = AccountMapper.mapToAccount(accountdto);
		Account SaveAccount = accountRepo.save(account);
		return AccountMapper.mapToAccountDto(SaveAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));

		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));

		double totalBalance = account.getBalance() + amount;
		account.setBalance(totalBalance);
		Account saveAccount = accountRepo.save(account);

		return AccountMapper.mapToAccountDto(saveAccount);
	}

	@Override
	public AccountDto withDraw(Long id, double amount) {
		Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		if (account.getBalance() < amount) {
			throw new RuntimeException("Insufficient Balance");

		}
		double totalBalance = account.getBalance() - amount;
		account.setBalance(totalBalance);

		Account saveAccount = accountRepo.save(account);

		return AccountMapper.mapToAccountDto(saveAccount);

	}

	@Override
	public List<AccountDto> getAllAccount() {
		return accountRepo.findAll().stream().map((account) -> AccountMapper.mapToAccountDto(account))
				.collect(Collectors.toList());

	}

	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		accountRepo.delete(account);
	}

}
