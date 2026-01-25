package com.reljicd.service;

import com.reljicd.exception.InsufficientFundsException;
import com.reljicd.model.Account;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Service to handle the logic of moving funds between accounts.
 */
public interface TransactionService {

    // Stages an account for a transfer (similar to adding to cart)
    void selectAccountForTransfer(Account account);

    // Removes an account from the current transaction staging
    void deselectAccount(Account account);

    // Returns the accounts involved in the current pending transaction
    Map<Account, Integer> getAccountsInSummary();

    // The banking equivalent of "checkout"
    void executeTransfer() throws InsufficientFundsException;

    // Calculates the total value of the pending transfer or net worth
    BigDecimal getTotalNetWorth();
}
