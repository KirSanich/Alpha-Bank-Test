package com.example.alphabanktest.exchange.client;

import com.example.alphabanktest.config.WireMockConfig;
import com.example.alphabanktest.exchange.configuration.ExchangeConfiguration;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WireMockConfig.class })
public class ExchangeClientIntegrationTest {

    @Autowired
    private WireMockServer mockBooksService;

    @Autowired
    private ExchangeClient exchangeClient;

    @Autowired
    private ExchangeConfiguration exchangeConfiguration;

    @BeforeEach
    void setUp() throws IOException {
        ExchangeMocks.setupMockExchangeResponse(mockBooksService);
    }

    @Test
    public void getResponseExchangeByTodayDate() {
        assertTrue(exchangeClient.getExchangeRateByDate(
                exchangeConfiguration.getAppId(),
                exchangeConfiguration.getBase(),
               "2022-05-31").hasBody());
    }

}
