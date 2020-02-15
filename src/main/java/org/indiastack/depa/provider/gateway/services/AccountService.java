package org.indiastack.depa.provider.gateway.services;

import org.indiastack.depa.provider.gateway.dao.AccountDao;
import org.indiastack.depa.provider.gateway.models.account.Account;
import org.indiastack.depa.provider.gateway.models.account.http.DiscoverRequest;
import org.indiastack.depa.provider.gateway.models.account.http.DiscoverResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
        ArrayList<Account> accounts = getAccountsFromDiscoverRequest(discoverRequest);

        // @todo: Fetch account details from the bank backend

        accountDao.bulkSave(accounts);

        return new DiscoverResponse(discoverRequest, accounts);
    }

    private ArrayList<Account> getAccountsFromDiscoverRequest(DiscoverRequest discoverRequest) {
        ArrayList<Account> accounts = new ArrayList<>();

        for (String fiType : discoverRequest.getFiTypes()) {
            accounts.add(new Account(discoverRequest, fiType));
        }

        return accounts;
    }
}
