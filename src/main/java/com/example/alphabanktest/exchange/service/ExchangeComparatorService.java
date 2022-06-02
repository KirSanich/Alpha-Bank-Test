package com.example.alphabanktest.exchange.service;

import com.example.alphabanktest.exchange.dto.ExchangeRateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExchangeComparatorService implements ExchangeComparator
{
    @Override
    public int compareRates(ExchangeRateDTO today, ExchangeRateDTO yesterday, String code) {
        Double exchangeRateToday = today.getRates().get(code);
        log.info("Курc {} за сегодня по отношению к доллару равен {}", code, exchangeRateToday);
        Double exchangeRateYesterday = yesterday.getRates().get(code);
        log.info("Курc {} за вчера по отношению к доллару равен {}", code, exchangeRateYesterday);
        return exchangeRateToday.compareTo(exchangeRateYesterday);
    }
}
