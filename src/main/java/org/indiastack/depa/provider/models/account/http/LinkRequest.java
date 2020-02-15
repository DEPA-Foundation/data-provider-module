package org.indiastack.depa.provider.models.account.http;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
