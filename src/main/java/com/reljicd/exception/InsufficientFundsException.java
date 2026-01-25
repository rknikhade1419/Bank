package com.reljicd.exception;

import com.reljicd.model.Account;

/**
 * Thrown when a user attempts a transaction that exceeds their current balance.
 */
public class InsufficientFundsException extends Exception {

    private static final String DEFAULT_MESSAGE = "Insufficient funds to complete the transaction.";

    public InsufficientFundsException() {
        super(DEFAULT_MESSAGE);
    }

    public InsufficientFundsException(Account account) {
        super(String.format("Transaction failed: Account %s has a balance of $%.2f, which is less than the requested amount.", 
                account.getAccountNumber(), 
                account.getBalance()));
    }
}
