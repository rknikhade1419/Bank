package com.reljicd.exception;

public class AccountNotFoundException extends Exception {
    
    public AccountNotFoundException(String accountNumber) {
        super("Account not found: " + accountNumber);
    }
    
    public AccountNotFoundException(Long accountId) {
        super("Account not found with ID: " + accountId);
    }
}
