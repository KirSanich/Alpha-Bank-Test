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
        log.info("The exchange rate {} for today in relation to 1 dollar - {}", code, exchangeRateToday);
        Double exchangeRateYesterday = yesterday.getRates().get(code);
        log.info("The exchange rate {} for yesterday in relation to 1 dollar - {}", code, exchangeRateYesterday);
        return exchangeRateToday.compareTo(exchangeRateYesterday);
    }
}
