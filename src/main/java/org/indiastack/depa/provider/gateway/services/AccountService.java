package org.indiastack.depa.provider.gateway.services;

import org.indiastack.depa.provider.gateway.dao.AccountDao;
import org.indiastack.depa.provider.gateway.models.account.Account;
import org.indiastack.depa.provider.gateway.models.account.http.DiscoverRequest;
import org.indiastack.depa.provider.gateway.models.account.http.DiscoverResponse;
import org.indiastack.depa.provider.gateway.models.account.http.LinkRequest;
import org.indiastack.depa.provider.gateway.models.account.http.LinkResponse;
import org.indiastack.depa.provider.integrations.banks.utils.BankDiscoverAccountUtils;
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
        ArrayList<Account> accounts = BankDiscoverAccountUtils.getAccounts(discoverRequest);

        // @todo: Fetch account details from the bank backend
        accountDao.batchInsert(accounts);
        return new DiscoverResponse(discoverRequest, accounts);
    }

    public LinkResponse linkAccount(LinkRequest linkRequest) {
        // Get all accounts in the linkRequest from the database
        // Update link status to LINKED
        // Generate Token?? @Todo
        return new LinkResponse();
    }
}
