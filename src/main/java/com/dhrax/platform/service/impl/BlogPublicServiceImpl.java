package com.dhrax.platform.service.impl;

import com.dhrax.platform.dto.BlogPublicResponse;
import com.dhrax.platform.entity.Blog;
import com.dhrax.platform.entity.BlogStatus;
import com.dhrax.platform.repository.BlogRepository;
import com.dhrax.platform.service.BlogPublicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPublicServiceImpl implements BlogPublicService {

    private final BlogRepository blogRepository;

    @Override
    public Page<BlogPublicResponse> listPublished(int page, int size) {

        PageRequest pageable = PageRequest.of(
                page,
                size,
                Sort.by(Sort.Direction.DESC, "publishedAt")
        );

        return blogRepository
                .findAllByStatus(BlogStatus.PUBLISHED, pageable)
                .map(this::toResponse);
    }


    @Override
    public BlogPublicResponse getBySlug(String slug) {
        Blog blog = blogRepository
                .findBySlugAndStatus(slug, BlogStatus.PUBLISHED)
                .orElseThrow(() -> new IllegalArgumentException("Blog not found"));

        return toResponse(blog);
    }

    private BlogPublicResponse toResponse(Blog blog) {
        return BlogPublicResponse.builder()
                .title(blog.getTitle())
                .slug(blog.getSlug())
                .summary(blog.getSummary())
                .content(blog.getContent())
                .publishedAt(blog.getPublishedAt())
                .build();
    }
}
