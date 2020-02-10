package org.indiastack.depa.provider.gateway.models.consent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@NoArgsConstructor
public class Consent {
    private String Id;
    private String accountAggregatorId;
    private Integer frequency;
    private ConsentStatus status;
    private Date lastAccessedAt;
}
