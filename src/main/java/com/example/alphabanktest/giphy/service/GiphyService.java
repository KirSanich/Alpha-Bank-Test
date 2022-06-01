package com.example.alphabanktest.giphy.service;

import com.example.alphabanktest.giphy.dto.GiphyComplexDTO;

public interface GiphyService {
    GiphyComplexDTO getGiphyByRateWithCode(String code);
}
