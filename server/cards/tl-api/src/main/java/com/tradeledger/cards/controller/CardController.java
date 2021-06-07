package com.tradeledger.cards.controller;

import com.tradeledger.cards.common.Applicant;
import com.tradeledger.cards.model.Eligibility;
import com.tradeledger.cards.service.CardEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/lt/api")
public class CardController {
    @Autowired
    private CardEligibilityService cardEligibilityService;

    @RequestMapping(method = RequestMethod.POST,
            path = "/card/eligibility/check",
            consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Eligibility checkEligibility(@Valid @RequestBody Applicant applicant){
        return cardEligibilityService.checkEligibility(applicant);
    }
}
