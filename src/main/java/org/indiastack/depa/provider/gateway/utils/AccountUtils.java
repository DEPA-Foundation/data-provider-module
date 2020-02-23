package org.indiastack.depa.provider.gateway.utils;

import org.indiastack.depa.generated.jooq.tables.records.AccountsRecord;
import org.indiastack.depa.provider.gateway.models.account.Account;

public class AccountUtils {
    public static AccountsRecord toRecord(Account account) {
        AccountsRecord accountsRecord = new AccountsRecord();

        accountsRecord.setAaId(account.getAaId());
        accountsRecord.setCustomerAaId(account.getCustomerAAId());
        accountsRecord.setNumber(account.getNumber());
        accountsRecord.setBankRefNumber(account.getBankRefNumber());
        accountsRecord.setStatus(account.getStatus().toString());
        accountsRecord.setType(account.getType());

        return accountsRecord;
    }
}
