package org.indiastack.depa.provider.gateway.models.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
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

    private UUID id;
    // @todo: Definition of linkRefNumber
    private String linkRefNumber;

    private String aaId;
    private String customerAAId;

    // @todo: which accountNumber is this?
    private String accountNumber;

    // @todo: which accountRefNumber is this?
    private String accountRefNumber;
    private AccountStatus status;
    private AccountType type;
    private Date createdAt;
    private Date updatedAt;

    public Account(String linkRefNumber, String aaId, String customerAAId, String accountNumber, String accountRefNumber, AccountType type) {
        this.linkRefNumber = linkRefNumber;
        this.aaId = aaId;
        this.customerAAId = customerAAId;
        this.accountNumber = accountNumber;
        this.accountRefNumber = accountRefNumber;
        this.type = type;

        this.status = AccountStatus.INITIATED;
    }
}
