package com.dhrax.platform.service;

import com.dhrax.platform.dto.BlogPublicResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BlogPublicService {

    Page<BlogPublicResponse> listPublished(int page, int size);

    BlogPublicResponse getBySlug(String slug);
}
