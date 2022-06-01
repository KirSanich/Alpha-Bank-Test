package com.example.alphabanktest.exchange.service;

import com.example.alphabanktest.exchange.dto.ExchangeRateDTO;

import java.util.List;

public interface ExchangeService {
   ExchangeRateDTO getTodayExchangeRate();
   ExchangeRateDTO getYesterdayExchangeRate();
}
