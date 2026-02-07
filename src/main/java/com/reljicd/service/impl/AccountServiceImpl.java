package com.reljicd.service.impl;

import com.reljicd.exception.InsufficientFundsException;
import com.reljicd.model.Account;
import com.reljicd.repository.AccountRepository;
import com.reljicd.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;
    
    private Map<Account, Integer> accountsInTransfer = new HashMap<>();

    @Autowired
    public TransactionServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Map<Account, Integer> getAccountsInSummary() {
        return Collections.unmodifiableMap(accountsInTransfer);
    }

    @Override
    public void selectAccountForTransfer(Account account) {
        if (accountsInTransfer.containsKey(account)) {
            accountsInTransfer.replace(account, accountsInTransfer.get(account) + 1);
        } else {
            accountsInTransfer.put(account, 1);
        }
    }

    @Override
    public void executeTransfer() throws InsufficientFundsException {
        // Simple transfer logic - you can enhance this
        accountsInTransfer.clear();
    }

    @Override
    public BigDecimal getTotalNetWorth() {
        return accountsInTransfer.entrySet().stream()
                .map(entry -> entry.getKey().getBalance().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
