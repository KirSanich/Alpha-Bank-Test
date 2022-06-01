package com.example.alphabanktest.giphy.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class GiphyDTO {

    @JsonProperty(value = "type")
    private String type;

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "slug")
    private String slug;

    @JsonProperty(value = "url")
    private String url;

    @JsonProperty(value = "embed_url")
    private String embedUrl;

    @JsonProperty(value = "source")
    private String source;

    @JsonProperty(value = "rating")
    private String rating;

    @JsonProperty(value = "import_datetime")
    private String importDatetime;

    @JsonProperty(value = "title")
    private String title;

}
