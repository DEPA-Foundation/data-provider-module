package org.indiastack.depa.provider.models.consent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@Getter
@NoArgsConstructor
public class Consent {
    private UUID Id;
    private Integer accountId;
    private ConsentStatus status;
    private ConsentFetchType fetchType;

    // @todo: discuss sample values
    private String types;

    // @todo: discuss sample values
    private String fiTypes;

    private ConsentMode mode;
    private Integer frequency;

    private String dataFilterType;
    private String dataFilterOperator;
    private String dataFilterValue;

    private Date lastAccessedAt;
    private Date startTimestamp;
    private Date endTimestamp;
    private Date dataStartTimestamp;
    private Date dataEndTimestamp;


    public Consent(Integer accountId,
                   String fetchType,
                   String types,
                   String fiTypes,
                   String mode,
                   Integer frequency,
                   String dataFilterType,
                   String dataFilterOperator,
                   String dataFilterValue,
                   Date startTimestamp,
                   Date endTimestamp,
                   Date dataStartTimestamp,
                   Date dataEndTimestamp) {
        this.accountId = accountId;
        this.types = types;
        this.fiTypes = fiTypes;
        this.frequency = frequency;
        this.dataFilterType = dataFilterType;
        this.dataFilterOperator = dataFilterOperator;
        this.dataFilterValue = dataFilterValue;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.dataStartTimestamp = dataStartTimestamp;
        this.dataEndTimestamp = dataEndTimestamp;

        this.status = ConsentStatus.INITIATED;
        this.fetchType = ConsentFetchType.valueOf(fetchType);
        this.mode = ConsentMode.valueOf(mode);
    }
}
