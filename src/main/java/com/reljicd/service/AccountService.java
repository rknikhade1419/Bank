package com.reljicd.service;

import com.reljicd.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    
    List<Account> findAllAccounts();
    
    Optional<Account> findAccountById(Long id);
    
    Optional<Account> findAccountByAccountNumber(String accountNumber);
    
    Account saveAccount(Account account);
    
    void deleteAccount(Long id);
    
    Account findById(Long id);
    
    Page<Account> findAllAccountsPageable(Pageable pageable);
}
