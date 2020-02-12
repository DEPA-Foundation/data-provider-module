package org.indiastack.depa.provider.gateway.controllers.v1;

import org.indiastack.depa.provider.gateway.models.consent.Consent;
import org.indiastack.depa.provider.gateway.services.ConsentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/gateway/consents")
public class ConsentController {
    private ConsentService consentService;

    @Autowired
    public ConsentController(ConsentService consentService) {
        this.consentService = consentService;
    }

    @GetMapping("/{consentId}")
    public Consent getConsent(@PathVariable("consentId") String consentId) {
        return consentService.getConsent(consentId);
    }

    @PostMapping("")
    public Consent createConsent(@RequestBody Consent consent) {
        return consentService.createConsent(consent);
    }
}
