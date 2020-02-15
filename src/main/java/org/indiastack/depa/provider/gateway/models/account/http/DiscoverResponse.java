package org.indiastack.depa.provider.gateway.models.account.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.indiastack.depa.provider.gateway.models.account.Account;
import org.indiastack.depa.provider.gateway.utils.DateUtils;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
public class DiscoverResponse {
    @JsonProperty("ver")
    private String version;
    private String timestamp;

    @JsonProperty("txnid")
    private String transactionId;

    @JsonProperty("DiscoveredAccounts")
    private ArrayList<DiscoveredAccount> discoveredAccounts;

    public DiscoverResponse() {
        this.discoveredAccounts = new ArrayList<>();
    }

    public DiscoverResponse(DiscoverRequest discoverRequest, Account account) {
        this.discoveredAccounts = new ArrayList<>();
        this.discoveredAccounts.add(new DiscoveredAccount(account));

        this.version = discoverRequest.getVersion();
        this.transactionId = discoverRequest.getTransactionId();
        this.timestamp = DateUtils.getISODateInUTC();
    }
}
