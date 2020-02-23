package org.indiastack.depa.provider.gateway.controllers.v1;

import org.indiastack.depa.provider.gateway.models.account.http.DiscoverRequest;
import org.indiastack.depa.provider.gateway.models.account.http.DiscoverResponse;
import org.indiastack.depa.provider.gateway.models.account.http.LinkRequest;
import org.indiastack.depa.provider.gateway.models.account.http.LinkResponse;
import org.indiastack.depa.provider.gateway.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * @author: Jayesh Sidhwani
 *
 * AccountsController is responsible for managing all Account Linking requests
 */

@RestController
@RequestMapping("Accounts")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/discover")
    public DiscoverResponse discoverAccounts(@RequestBody DiscoverRequest discoverRequest) {
        return accountService.discoverAccount(discoverRequest);
    }

    @PostMapping("/link")
    public LinkResponse linkAccount(@RequestBody LinkRequest linkRequest) {
        return accountService.linkAccount(linkRequest);
    }

    @DeleteMapping("/link")
    public String deleteAccountLink() {
        return "NOT_IMPLEMENTED";
    }

    @GetMapping("/link/{RefNumber}/{Token}")
    public String getLinkedAccount(@PathVariable String refNumber, @PathVariable String token) {
        return "NOT_IMPLEMENTED";

    }
}
