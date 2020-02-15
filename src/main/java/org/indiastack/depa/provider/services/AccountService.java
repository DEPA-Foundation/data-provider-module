package org.indiastack.depa.provider.services;

import org.indiastack.depa.provider.dao.AccountDao;
import org.indiastack.depa.provider.models.account.Account;
import org.indiastack.depa.provider.models.account.http.DiscoverRequest;
import org.indiastack.depa.provider.models.account.http.DiscoverResponse;
import org.indiastack.depa.provider.models.account.http.LinkRequest;
import org.indiastack.depa.provider.models.account.http.LinkResponse;
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

    public DiscoverResponse discoverAccount(DiscoverRequest discoverRequest) {
        // Requests is of multiple fiTypes but response is of an array of accounts
        ArrayList<Account> accounts = getAccountsFromDiscoverRequest(discoverRequest);

        // @todo: Fetch account details from the bank backend
        accountDao.bulkSave(accounts);
        return new DiscoverResponse(discoverRequest, accounts);
    }

    public LinkResponse linkAccount(LinkRequest linkRequest) {
        // Get all accounts from the database
        // Update link status to LINKED
        // Generate Token?? @Todo
        return new LinkResponse();
    }

    private ArrayList<Account> getAccountsFromDiscoverRequest(DiscoverRequest discoverRequest) {
        ArrayList<Account> accounts = new ArrayList<>();

        for (String fiType : discoverRequest.getFiTypes()) {
            accounts.add(new Account(discoverRequest, fiType));
        }

        return accounts;
    }
}
