package com.reljicd.service;

import com.reljicd.exception.InsufficientFundsException;
import com.reljicd.model.Account;

import java.math.BigDecimal;
import java.util.Map;

public interface TransactionService {
    
    Map<Account, Integer> getAccountsInSummary();
    
    void selectAccountForTransfer(Account account);
    
    void executeTransfer() throws InsufficientFundsException;
    
    BigDecimal getTotalNetWorth();
}
