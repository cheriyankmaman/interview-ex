package com.tradeledger.cards.service;

import com.tradeledger.cards.common.Applicant;
import com.tradeledger.cards.model.Eligibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CardEligibilityService {
    private RestTemplate restTemplate;

    public CardEligibilityService(final RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Eligibility checkEligibility(Applicant applicant){
        HttpEntity<?> requestEntity = new HttpEntity<>(applicant);
        ResponseEntity<Eligibility> eligibility = restTemplate.exchange("http://localhost:3317/eligibility/check",
                HttpMethod.POST,
                requestEntity,
                Eligibility.class);
        return eligibility.getBody();
    }
}
