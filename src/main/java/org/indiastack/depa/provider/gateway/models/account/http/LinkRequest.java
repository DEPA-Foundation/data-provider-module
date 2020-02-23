package org.indiastack.depa.provider.gateway.models.account.http;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.indiastack.depa.provider.gateway.models.commons.http.BaseRequest;

@NoArgsConstructor
@Getter
public class LinkRequest extends BaseRequest {
    @JsonProperty("Customer")
    private LinkCustomer linkCustomer;

    public LinkRequest(String version, String timestamp, String transactionId, LinkCustomer linkCustomer) {
        super(version, timestamp, transactionId);
        this.linkCustomer = linkCustomer;
    }
}
