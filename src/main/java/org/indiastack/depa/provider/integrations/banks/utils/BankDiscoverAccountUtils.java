package org.indiastack.depa.provider.integrations.banks.utils;

import lombok.extern.java.Log;
import org.indiastack.depa.provider.gateway.models.account.Account;
import org.indiastack.depa.provider.gateway.models.account.AccountType;
import org.indiastack.depa.provider.gateway.models.account.http.DiscoverRequest;

import java.util.ArrayList;

@Log
public class BankDiscoverAccountUtils {

    // {{ DiscoverRequest }} has multiple fITypes
    // We make an account fetch request to the bank for individual fiType
    public static ArrayList<Account> getAccounts(DiscoverRequest discoverRequest) {
        ArrayList<Account> accounts = new ArrayList<>();
        log.info("Using dummy implementation for: " + BankDiscoverAccountUtils.class.getName());

        for (String fiType : discoverRequest.getFiTypes()) {
            log.info("Fetching accounts for FI Type " + fiType);
            log.info("Performing dummy fetch request for " + fiType);

            Account a = new Account("DUMMY_AA",
                discoverRequest.getDiscoverCustomer().getId(),
                "ACC-1029",
                "BANK-ACC-1029",
                AccountType.SAVINGS);
            accounts.add(a);
        }
        return accounts;
    }

}
