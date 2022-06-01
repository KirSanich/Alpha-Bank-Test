package com.example.alphabanktest.exchange.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
public class ExchangeRateDTO {

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("base")
    private String base;

    @JsonProperty("rates")
    private Map<String, Double> rates;


}
