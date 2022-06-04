package com.example.alphabanktest.exchange.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExchangeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Get giphy")
    public void shouldReturnGiphy() throws Exception {
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("code", "RUB");
        mockMvc.perform(MockMvcRequestBuilders.get("/currency")
                        .params(requestParams))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Incorrect request param")
    public void getGifBadGateWay() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/currency")
                        .param("base", "RUBFRT"))
                .andExpect(status().isBadRequest());
    }

}