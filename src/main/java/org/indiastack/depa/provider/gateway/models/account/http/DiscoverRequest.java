package org.indiastack.depa.provider.gateway.models.account.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.indiastack.depa.provider.gateway.models.commons.http.BaseRequest;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DiscoverRequest extends BaseRequest {
    @JsonProperty("Customer")
    private DiscoverCustomer discoverCustomer;

    @JsonProperty("FITypes")
    private ArrayList<String> fiTypes;

    public DiscoverRequest(String version, String timestamp, String transactionId, DiscoverCustomer discoverCustomer, ArrayList<String> fiTypes) {
        super(version, timestamp, transactionId);
        this.discoverCustomer = discoverCustomer;
        this.fiTypes = fiTypes;
    }
}
