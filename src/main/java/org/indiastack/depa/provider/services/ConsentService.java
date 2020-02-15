package org.indiastack.depa.provider.services;

import org.indiastack.depa.provider.models.consent.Consent;
import org.springframework.stereotype.Service;

@Service
public class ConsentService {

    public Consent createConsent(Consent consent) {
        return new Consent();
    }
}
