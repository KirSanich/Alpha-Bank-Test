package com.example.alphabanktest.giphy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
public class GiphyComplexDTO {

    @JsonProperty(value = "data")
    private GiphyDTO[] giphy;
}
