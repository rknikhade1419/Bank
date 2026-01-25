package com.reljicd.controller;

import com.reljicd.model.Account; // Renamed from Product
import com.reljicd.service.AccountService; // Renamed from ProductService
import com.reljicd.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class HomeController {

    private static final int INITIAL_PAGE = 0;
    private static final int PAGE_SIZE = 5;

    private final AccountService accountService;

    @Autowired
    public HomeController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/home")
    public ModelAndView home(@RequestParam("page") Optional<Integer> page) {

        // Evaluate page index (Spring Data Pages are 0-indexed)
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        // Fetch accounts instead of products
        Page<Account> accounts = accountService.findAllAccountsPageable(new PageRequest(evalPage, PAGE_SIZE));
        Pager pager = new Pager(accounts);

        ModelAndView modelAndView = new ModelAndView();
        
        // Match these names to the th:each="account : ${accounts}" in your HTML
        modelAndView.addObject("accounts", accounts);
        modelAndView.addObject("pager", pager);
        modelAndView.setViewName("/home");
        
        return modelAndView;
    }
}
