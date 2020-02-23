package org.indiastack.depa.provider.gateway.models.commons.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BaseRequest {
    @JsonProperty("ver")
    private String version;

    private String timestamp;

    @JsonProperty("txnid")
    private String transactionId;
}
