package org.indiastack.depa.provider.gateway.services;

import org.indiastack.depa.provider.gateway.dao.AccountDao;
import org.indiastack.depa.provider.gateway.models.account.Account;
import org.indiastack.depa.provider.gateway.models.account.http.DiscoverRequest;
import org.indiastack.depa.provider.gateway.models.account.http.DiscoverResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private AccountDao accountDao;

    @Autowired
    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account getAccount(String Id) {
        return new Account();
    }

    public Account createAccount(Account accountRequest) {
        return new Account();
    }

    public DiscoverResponse discoverAccount(DiscoverRequest discoverRequest) {
        // Requests is of multiple fiTypes but response is of an array of accounts
        Account account = new Account(discoverRequest);
        accountDao.save(account);
        return new DiscoverResponse(discoverRequest, account);
    }
}
