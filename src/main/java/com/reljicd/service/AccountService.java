package com.reljicd.service;

import com.reljicd.model.Account; // Renamed from Product
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service interface for managing Banking Accounts.
 */
public interface AccountService {

    /**
     * Finds a specific account by its database ID.
     */
    Optional<Account> findById(Long id);

    /**
     * Retrieves a paginated list of accounts.
     * Useful for the Admin dashboard or a user with many sub-accounts.
     */
    Page<Account> findAllAccountsPageable(Pageable pageable);

}
