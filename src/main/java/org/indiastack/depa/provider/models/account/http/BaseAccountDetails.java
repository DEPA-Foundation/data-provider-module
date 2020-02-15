package org.indiastack.depa.provider.models.account.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.indiastack.depa.provider.models.account.Account;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BaseAccountDetails {
    @JsonProperty("FIType")
    private String fiType;

    @JsonProperty("accType")
    private String accountType;

    @JsonProperty("accRefNumber")
    private String accountRefNumber;

    @JsonProperty("maskedAccNumber")
    private String maskedAccountNumber;

    public BaseAccountDetails(Account account) {
        this.fiType = account.getType();

        this.accountRefNumber = account.getAccountRefNumber();
        this.maskedAccountNumber = account.getAccountNumber();
    }
}
