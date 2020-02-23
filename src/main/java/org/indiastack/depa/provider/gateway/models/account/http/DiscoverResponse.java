package org.indiastack.depa.provider.gateway.models.account.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.indiastack.depa.provider.gateway.models.account.Account;
import org.indiastack.depa.provider.gateway.models.commons.http.BaseResponse;
import org.indiastack.depa.provider.gateway.utils.DateUtils;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
public class DiscoverResponse extends BaseResponse {
    @JsonProperty("DiscoveredAccounts")
    private ArrayList<BaseAccountDetails> baseAccountDetails;

    public DiscoverResponse() {
        this.baseAccountDetails = new ArrayList<>();
    }

    public DiscoverResponse(DiscoverRequest discoverRequest, ArrayList<Account> accounts) {
        super(discoverRequest.getVersion(), DateUtils.getISODateInUTC(), discoverRequest.getTransactionId());

        this.baseAccountDetails = new ArrayList<>();
        for (Account account : accounts) {
            this.baseAccountDetails.add(new BaseAccountDetails(account));
        }
    }
}
