package org.indiastack.depa.provider.models.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.indiastack.depa.provider.models.account.http.DiscoverRequest;
import org.indiastack.depa.provider.models.account.http.LinkRequest;
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

    public Account(String linkRefNumber,
                   String aaId,
                   String customerAAId,
                   String accountNumber,
                   String accountRefNumber,
                   AccountType type) {
        this.linkRefNumber = linkRefNumber;
        this.aaId = aaId;
        this.customerAAId = customerAAId;
        this.accountNumber = accountNumber;
        this.accountRefNumber = accountRefNumber;
        this.type = type;

        this.status = AccountStatus.INITIATED;
    }

    public Account(DiscoverRequest discoverRequest, String fiType) {
        this.status = AccountStatus.INITIATED;
        this.aaId = "DEFAULT_AA";
        this.customerAAId = discoverRequest.getDiscoverCustomer().getId();

        try {
            this.type = AccountType.valueOf(fiType);
        } catch (IllegalArgumentException iae) {
            System.out.println("Unsupported fiType");
        }
    }


    public String getType() {
        if (this.type == null) {
            return "";
        } else {
            return this.type.toString();
        }
    }
}
