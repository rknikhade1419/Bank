package com.reljicd.util;

import com.reljicd.model.Account;
import org.springframework.data.domain.Page;

/**
 * Utility class to handle pagination logic for the Banking UI.
 * It wraps the Spring Data Page object to provide easy-to-use methods for Thymeleaf.
 */
public class Pager {

    private final Page<Account> accounts;

    public Pager(Page<Account> accounts) {
        this.accounts = accounts;
    }

    public int getPageIndex() {
        // Spring pages are 0-based, but we display 1-based to users
        return accounts.getNumber() + 1;
    }

    public int getPageSize() {
        return accounts.getSize();
    }

    public boolean hasNext() {
        return accounts.hasNext();
    }

    public boolean hasPrevious() {
        return accounts.hasPrevious();
    }

    public int getTotalPages() {
        return accounts.getTotalPages();
    }

    public long getTotalElements() {
        return accounts.getTotalElements();
    }

    public boolean indexOutOfBounds() {
        return this.getPageIndex() < 0 || this.getPageIndex() > this.getTotalPages();
    }
}
