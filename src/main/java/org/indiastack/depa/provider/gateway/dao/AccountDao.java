package org.indiastack.depa.provider.gateway.dao;

import org.indiastack.depa.generated.jooq.tables.records.AccountsRecord;
import org.indiastack.depa.provider.gateway.models.account.Account;
import org.indiastack.depa.provider.gateway.utils.AccountUtils;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountDao {
    private DSLContext db;

    @Autowired
    public AccountDao(DSLContext db) {
        this.db = db;
    }

    public void batchInsert(ArrayList<Account> accounts) {
        List<AccountsRecord> records = accounts.stream()
            .map(AccountUtils::toRecord)
            .collect(Collectors.toList());

        db.batchInsert(records).execute();
    }
}
