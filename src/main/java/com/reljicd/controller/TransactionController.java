package com.reljicd.controller;

import com.reljicd.exception.InsufficientFundsException;
import com.reljicd.service.AccountService;
import com.reljicd.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransactionController {

    private final TransactionService transactionService;
    private final AccountService accountService;

    @Autowired
    public TransactionController(TransactionService transactionService, AccountService accountService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    @GetMapping("/dashboard")
    public ModelAndView showDashboard() {
        ModelAndView modelAndView = new ModelAndView("/shoppingCart"); // Reusing your dashboard template
        modelAndView.addObject("accounts", transactionService.getAccountsInSummary());
        modelAndView.addObject("totalBalance", transactionService.getTotalNetWorth().toString());
        return modelAndView;
    }

    @GetMapping("/transfer/add/{accountId}")
    public ModelAndView prepareTransfer(@PathVariable("accountId") Long accountId) {
        accountService.findById(accountId).ifPresent(transactionService::selectAccountForTransfer);
        return showDashboard();
    }

    @GetMapping("/transfer/confirm")
    public ModelAndView processTransaction() {
        try {
            transactionService.executeTransfer();
            return showDashboard().addObject("transactionMessage", "Transfer completed successfully!");
        } catch (InsufficientFundsException e) {
            return showDashboard().addObject("errorMessage", e.getMessage());
        }
    }
}
