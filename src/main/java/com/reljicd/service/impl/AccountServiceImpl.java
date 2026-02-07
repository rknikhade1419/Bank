package com.reljicd.service.impl;

import com.reljicd.model.Account;
import com.reljicd.repository.AccountRepository;
import com.reljicd.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findAccountById(Long id) {
        // Spring Boot 1.5.x uses findOne() instead of findById()
        Account account = accountRepository.findOne(id);
        return Optional.ofNullable(account);
    }

    @Override
    public Optional<Account> findAccountByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
        // Spring Boot 1.5.x uses delete(Long id) instead of deleteById(Long id)
        accountRepository.delete(id);
    }

    @Override
    public Account findById(Long id) {
        // Spring Boot 1.5.x uses findOne() instead of findById()
        return accountRepository.findOne(id);
    }

    @Override
    public Page<Account> findAllAccountsPageable(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }
}
