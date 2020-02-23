package org.indiastack.depa.provider.gateway.models.account.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.indiastack.depa.provider.gateway.models.commons.http.BaseResponse;

@NoArgsConstructor
@Getter
public class LinkResponse extends BaseResponse {
    @JsonProperty("AuthenticatorType")
    private AuthenticatorTypes authenticatorType;

    @JsonProperty("RefNumber")
    private String referenceNumber;
}
