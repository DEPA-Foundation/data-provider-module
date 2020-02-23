package org.indiastack.depa.provider.gateway.services;

import org.indiastack.depa.provider.gateway.models.consent.Consent;
import org.springframework.stereotype.Service;

@Service
public class ConsentService {

    public Consent createConsent(Consent consent) {
        return new Consent();
    }
}
