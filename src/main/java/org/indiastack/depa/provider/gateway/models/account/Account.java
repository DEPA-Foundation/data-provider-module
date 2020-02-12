package org.indiastack.depa.provider.gateway.models.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

/*
 * Account module stores the record of the linked account of the user
 *
 * Account is a polymorphic model and can be either a Bank account, Demat account, or lending account etc.
 * The different types of accounts will be built as the project matures
 *
 */
@Component
@NoArgsConstructor
@Getter
public class Account {

    private String id;
    private String accountAggregatorId;
    private AccountStatus status;
    private AccountCategory category;
    private String name;
    private String userId;

    public Account(String accountAggregatorId, AccountCategory category, String name, String userId) {
        this.id = createId();
        this.status = AccountStatus.INITIATED;

        this.accountAggregatorId = accountAggregatorId;
        this.category = category;
        this.name = name;
        this.userId = userId;
    }

    private String createId() {
        return UUID.randomUUID().toString();
    }
}
