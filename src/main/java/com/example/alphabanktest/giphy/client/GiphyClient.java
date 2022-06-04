package com.example.alphabanktest.giphy.client;


import com.example.alphabanktest.giphy.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "giphy-api", url = "${application.giphy.url}")
public interface GiphyClient {

    @GetMapping(value = "${application.giphy.search}")
  ResponseEntity<GiphyComplexDTO> getRandomGiphy(
            @RequestParam("api_key") String api_key,
            @RequestParam("q") String param,
            @RequestParam("limit") String limit,
            @RequestParam("offset") String offset
            );

}
