package com.cognizant.accountservice.controller;

import com.cognizant.accountservice.model.Account;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @GetMapping
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1, "Ananya Rathod", 15000.0));
        accounts.add(new Account(2, "Ravi Kumar", 25000.0));
        accounts.add(new Account(3, "Priya Sharma", 32000.5));
        return accounts;
    }
}
