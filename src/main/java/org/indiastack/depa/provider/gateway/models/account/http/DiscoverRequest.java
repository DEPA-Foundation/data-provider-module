package org.indiastack.depa.provider.gateway.models.account.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DiscoverRequest {
    @JsonProperty("ver")
    private String version;
    private String timestamp;

    @JsonProperty("txnid")
    private String transactionId;

    @JsonProperty("Customer")
    private Customer customer;

    @JsonProperty("FITypes")
    private ArrayList<String> fiTypes;
}
