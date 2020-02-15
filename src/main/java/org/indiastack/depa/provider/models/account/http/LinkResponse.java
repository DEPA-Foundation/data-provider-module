package org.indiastack.depa.provider.models.account.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LinkResponse extends BaseRequest {
    @JsonProperty("AuthenticatorType")
    private AuthenticatorTypes authenticatorType;

    @JsonProperty("RefNumber")
    private String referenceNumber;
}
