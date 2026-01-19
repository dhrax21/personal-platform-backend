package com.dhrax.platform.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BlogPublicResponse {

    private String title;
    private String slug;
    private String summary;
    private String content;
    private LocalDateTime publishedAt;
}
