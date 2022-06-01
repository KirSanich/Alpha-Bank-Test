package com.example.alphabanktest.exchange.configuration;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@ConfigurationProperties(prefix = "application.exchange")
public class ExchangeConfiguration {

    @Value("${application.exchange.url}")
    private String url;

    @Value("${application.exchange.key}")
    private String appId;

    @Value("${application.exchange.base}")
    private String base;

}

