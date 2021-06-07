package com.tradeledger.cards;

import com.tradeledger.cards.common.Applicant;
import com.tradeledger.cards.model.Eligibility;
import com.tradeledger.cards.service.CardEligibilityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardEligibilityService cardEligibilityService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testController() throws Exception {
        Eligibility eligibility = new Eligibility(Collections.singleton("c1"));

        Mockito.when(cardEligibilityService.checkEligibility(Mockito.any(Applicant.class))).thenReturn(eligibility);

        mockMvc.perform(post("/lt/api/card/eligibility/check").contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\":\"Boris\",\"address\":\"jbss sjjv skjsnv\",\"email\":\"cheriyan@gmail.com\"}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"eligibleCards\":[\"c1\"]}"));
    }
}
