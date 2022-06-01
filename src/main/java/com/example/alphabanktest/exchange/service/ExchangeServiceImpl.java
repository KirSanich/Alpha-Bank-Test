package com.example.alphabanktest.exchange.service;


import com.example.alphabanktest.exchange.client.ExchangeClient;
import com.example.alphabanktest.exchange.configuration.ExchangeConfiguration;
import com.example.alphabanktest.exchange.dto.ExchangeRateDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {
    @Autowired
    private final ExchangeClient exchangeClient;
    @Autowired
    private final ExchangeConfiguration exchangeConfiguration;
    @Override
        public ExchangeRateDTO getTodayExchangeRate() {
        String today = LocalDate.now().toString();
        log.info("Получение курсов валют по отношению к доллару сегодня");
        return exchangeClient.getExchangeRateByDate(
                exchangeConfiguration.getAppId(),
                exchangeConfiguration.getBase(),
                today
        );
    }
    @Override
    public ExchangeRateDTO getYesterdayExchangeRate() {
        String yesterday = LocalDate.now().minusDays(1).toString();
        log.info("Получение курсов валют по отношению к доллару за вчера");
        return exchangeClient.getExchangeRateByDate(
                exchangeConfiguration.getAppId(),
                exchangeConfiguration.getBase(),
                yesterday
        );
    }
}
