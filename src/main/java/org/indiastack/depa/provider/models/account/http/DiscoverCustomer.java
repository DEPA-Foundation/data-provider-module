package org.indiastack.depa.provider.models.account.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DiscoverCustomer {
    private String id;
    @JsonProperty("Identifiers")
    private ArrayList<CustomerIdentifier> identifiers;
}
