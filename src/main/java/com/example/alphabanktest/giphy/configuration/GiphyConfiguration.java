package com.example.alphabanktest.giphy.configuration;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@ConfigurationProperties(prefix = "application.giphy")
public class GiphyConfiguration {

    @Value("${application.giphy.url}")
    private String url;

    @Value("${application.giphy.key}")
    private String giphyKey;

    @Value("${application.giphy.param.rich}")
    private String richParam;

    @Value("${application.giphy.param.broke}")
    private String brokeParam;

    @Value("${application.giphy.search}")
    private String search;

    @Value("${application.giphy.limit}")
    private String limit;

    @Value("${application.giphy.offset}")
    private String offset;


}

