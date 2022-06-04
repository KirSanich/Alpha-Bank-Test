package com.example.alphabanktest.giphy.service;

import com.example.alphabanktest.exchange.dto.ExchangeRateDTO;
import com.example.alphabanktest.exchange.service.ExchangeComparator;
import com.example.alphabanktest.exchange.service.ExchangeService;
import com.example.alphabanktest.giphy.client.GiphyClient;
import com.example.alphabanktest.giphy.configuration.GiphyConfiguration;
import com.example.alphabanktest.giphy.dto.GiphyComplexDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
@RequiredArgsConstructor
public class GiphyServiceImpl implements GiphyService {

    @Autowired
    private final ExchangeService exchangeService;

    @Autowired
    private final GiphyClient giphyClient;

    @Autowired
    private final GiphyConfiguration giphyConfiguration;

    @Autowired
    private final ExchangeComparator exchangeComparator;


    @Override
    public GiphyComplexDTO getGiphyByRateWithCode(String code) {

        ExchangeRateDTO today = exchangeService.getTodayExchangeRate();
        ExchangeRateDTO yesterday = exchangeService.getYesterdayExchangeRate();

        int maxOffset = Integer.parseInt(giphyConfiguration.getOffset());
        int offset = ThreadLocalRandom.current().nextInt(0,maxOffset);
        String valueOfOffset = String.valueOf(offset);

        return switch (exchangeComparator.compareRates(today, yesterday, code)) {
            case 1 -> giphyClient.getRandomGiphy(
                    giphyConfiguration.getGiphyKey(),
                    giphyConfiguration.getRichParam(),
                    giphyConfiguration.getLimit(),
                    valueOfOffset
                    ).getBody();
            case -1 -> giphyClient.getRandomGiphy(
                    giphyConfiguration.getGiphyKey(),
                    giphyConfiguration.getBrokeParam(),
                    giphyConfiguration.getLimit(),
                    valueOfOffset).getBody();
            case 0 -> giphyClient.getRandomGiphy(
                    giphyConfiguration.getGiphyKey(),
                    "equal",
                    giphyConfiguration.getLimit(),
                    valueOfOffset).getBody();
            default -> {
                throw new RuntimeException("Не удается найти подходящую гифку!");
            }
        };
    }
}
