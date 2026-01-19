package com.dhrax.platform.dto;

import com.dhrax.platform.entity.BlogStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BlogAdminResponse {

    private Long id;
    private String title;
    private String slug;
    private BlogStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime publishedAt;
}
