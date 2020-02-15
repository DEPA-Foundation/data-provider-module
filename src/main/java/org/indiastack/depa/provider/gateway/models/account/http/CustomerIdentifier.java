package org.indiastack.depa.provider.gateway.models.account.http;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CustomerIdentifier {
    private String category;
    private String type;
    private String value;
}
