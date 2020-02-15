package org.indiastack.depa.provider.gateway.models.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.indiastack.depa.provider.gateway.models.account.http.DiscoverRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    private ArrayList<AccountType> type;

    public Account(String linkRefNumber,
                   String aaId,
                   String customerAAId,
                   String accountNumber,
                   String accountRefNumber,
                   ArrayList<AccountType> type) {
        this.linkRefNumber = linkRefNumber;
        this.aaId = aaId;
        this.customerAAId = customerAAId;
        this.accountNumber = accountNumber;
        this.accountRefNumber = accountRefNumber;
        this.type = type;

        this.status = AccountStatus.INITIATED;
    }

    /*
     * @todo: handle NPE
     */
    public Account(DiscoverRequest discoverRequest) {
        this.type = new ArrayList<>();

        this.status = AccountStatus.INITIATED;
        this.aaId = "DEFAULT_AA";
        this.customerAAId = discoverRequest.getCustomer().getId();

        for (String fiType : discoverRequest.getFiTypes()) {
            try {
                this.type.add(AccountType.valueOf(fiType));
            } catch (NullPointerException npe) {
                System.out.println("NPE found " + fiType);
            }
        }
    }

    public String getTypeToString() {
        try {
            return this.type.get(0).toString();
        } catch (NullPointerException npe) {
            return null;
        }
    }
}
