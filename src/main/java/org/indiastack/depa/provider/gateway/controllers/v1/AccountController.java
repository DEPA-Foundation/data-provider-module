package org.indiastack.depa.provider.gateway.controllers.v1;

import org.indiastack.depa.provider.gateway.models.account.Account;
import org.indiastack.depa.provider.gateway.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * @author: Jayesh Sidhwani
 *
 * AccountsController is responsible for managing all Account Linking requests
 */

@RestController
@RequestMapping("v1/gateway/accounts")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountId}")
    public Account getAccount(@PathVariable("accountId") String accountId) {
        return accountService.getAccount(accountId);
    }

    @PostMapping("")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

}
