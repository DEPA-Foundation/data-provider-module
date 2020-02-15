package org.indiastack.depa.provider.gateway.models.account.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.indiastack.depa.provider.gateway.models.account.Account;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DiscoveredAccount {
    @JsonProperty("FIType")
    private String fiType;

    @JsonProperty("accType")
    private String accountType;

    @JsonProperty("accRefNumber")
    private String accountRefNumber;

    @JsonProperty("maskedAccNumber")
    private String maskedAccountNumber;

    public DiscoveredAccount(Account account) {
        this.fiType = account.getTypeToString();

        this.accountRefNumber = account.getAccountRefNumber();
        this.maskedAccountNumber = account.getAccountNumber();
    }
}
