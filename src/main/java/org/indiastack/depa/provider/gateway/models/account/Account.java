package org.indiastack.depa.provider.gateway.models.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@NoArgsConstructor
@Getter
public class Account {

    private UUID id;
    private String aaId;
    private String customerAAId;

    // @todo: which accountNumber is this?
    private String number;

    // @todo: which accountRefNumber is this?
    private String bankRefNumber;
    private AccountStatus status;
    private AccountType type;

    public Account(String aaId,
                   String customerAAId,
                   String number,
                   String bankRefNumber,
                   AccountType type) {
        this.aaId = aaId;
        this.customerAAId = customerAAId;
        this.number = number;
        this.bankRefNumber = bankRefNumber;
        this.type = type;

        this.status = defaultStatus();
    }

    public String getType() {
        if (this.type == null) {
            return "";
        } else {
            return this.type.toString();
        }
    }

    public void setType(String type) throws IllegalArgumentException {
        try {
            this.type = AccountType.valueOf(type);
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Unsupported value: " + type + " for AccountType");
        }
    }

    private AccountStatus defaultStatus() {
        return AccountStatus.DISCOVERED;
    }
}
