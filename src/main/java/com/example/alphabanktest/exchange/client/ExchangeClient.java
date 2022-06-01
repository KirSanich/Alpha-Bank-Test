package com.example.alphabanktest.exchange.client;

import com.example.alphabanktest.exchange.dto.ExchangeRateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "exchange-api", url = "${application.exchange.url}")
public interface ExchangeClient {
    @GetMapping(value = "/{date}.json")
    ExchangeRateDTO getExchangeRateByDate(
            @RequestParam(name = "app_id") String appId,
            @RequestParam(name = "base") String base,
            @PathVariable(name = "date") String localDate
    );

}

