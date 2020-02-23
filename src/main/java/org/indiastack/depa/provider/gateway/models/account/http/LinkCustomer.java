package org.indiastack.depa.provider.gateway.models.account.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LinkCustomer {
    private String id;

    @JsonProperty("Accounts")
    private ArrayList<BaseAccountDetails> baseAccountDetails;
}
