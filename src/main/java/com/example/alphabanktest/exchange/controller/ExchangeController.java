package com.example.alphabanktest.exchange.controller;

import com.example.alphabanktest.exchange.configuration.ExchangeConfiguration;
import com.example.alphabanktest.exchange.dto.ExchangeRateDTO;
import com.example.alphabanktest.giphy.dto.GiphyComplexDTO;
import com.example.alphabanktest.giphy.dto.GiphyDTO;
import com.example.alphabanktest.giphy.service.GiphyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeController {
    @Autowired
    private final GiphyService giphyService;

    @GetMapping("/currency")
    public ResponseEntity<GiphyDTO> getHelpByCurrency(@RequestParam(name = "code") String code) {
        GiphyComplexDTO giphyByRateWithCode = giphyService.getGiphyByRateWithCode(code);
        return ResponseEntity.ok(giphyByRateWithCode.getGiphy()[0]);
    }
}

