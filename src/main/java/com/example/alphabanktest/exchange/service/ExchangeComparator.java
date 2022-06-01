package com.example.alphabanktest.exchange.service;

import com.example.alphabanktest.exchange.dto.ExchangeRateDTO;

public interface ExchangeComparator {
    int compareRates(ExchangeRateDTO today, ExchangeRateDTO yesterday, String code);
}
