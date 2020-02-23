package org.indiastack.depa.provider.gateway.models.commons.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    @JsonProperty("ver")
    private String version;

    private String timestamp;

    @JsonProperty("txnid")
    private String transactionId;
}
