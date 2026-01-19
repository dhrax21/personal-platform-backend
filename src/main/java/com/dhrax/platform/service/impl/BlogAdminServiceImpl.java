package com.dhrax.platform.service.impl;

import com.dhrax.platform.dto.BlogAdminResponse;
import com.dhrax.platform.dto.BlogRequest;
import com.dhrax.platform.entity.Blog;
import com.dhrax.platform.entity.BlogStatus;
import com.dhrax.platform.repository.BlogRepository;
import com.dhrax.platform.service.BlogAdminService;
import com.dhrax.platform.util.SlugUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogAdminServiceImpl implements BlogAdminService {

    private final BlogRepository blogRepository;

    @Override
    public BlogAdminResponse create(BlogRequest request) {
        String baseSlug = SlugUtil.toSlug(request.getTitle());
        String slug = generateUniqueSlug(baseSlug);

        Blog blog = Blog.builder()
                .title(request.getTitle())
                .summary(request.getSummary())
                .content(request.getContent())
                .slug(slug)
                .status(BlogStatus.DRAFT)
                .build();

        return toResponse(blogRepository.save(blog));
    }

    @Override
    public BlogAdminResponse update(Long id, BlogRequest request) {
        Blog blog = getBlog(id);

        blog.setTitle(request.getTitle());
        blog.setSummary(request.getSummary());
        blog.setContent(request.getContent());

        return toResponse(blogRepository.save(blog));
    }

    @Override
    public List<BlogAdminResponse> findAll() {
        return blogRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public void publish(Long id) {
        Blog blog = getBlog(id);

        blog.setStatus(BlogStatus.PUBLISHED);
        blog.setPublishedAt(LocalDateTime.now());

        blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    /* ---------- Helpers ---------- */

    private Blog getBlog(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Blog not found"));
    }

    private String generateUniqueSlug(String baseSlug) {
        String slug = baseSlug;
        int counter = 1;

        while (blogRepository.existsBySlug(slug)) {
            slug = baseSlug + "-" + counter++;
        }
        return slug;
    }

    private BlogAdminResponse toResponse(Blog blog) {
        return BlogAdminResponse.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .slug(blog.getSlug())
                .status(blog.getStatus())
                .createdAt(blog.getCreatedAt())
                .updatedAt(blog.getUpdatedAt())
                .publishedAt(blog.getPublishedAt())
                .build();
    }
}
