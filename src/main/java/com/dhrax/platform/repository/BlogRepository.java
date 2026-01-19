package com.dhrax.platform.repository;

import com.dhrax.platform.entity.Blog;
import com.dhrax.platform.entity.BlogStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


 public interface BlogRepository extends JpaRepository<Blog, Long> {
        Optional<Blog> findBySlugAndStatus(String slug, BlogStatus status);
        List<Blog> findAllByStatusOrderByPublishedAtDesc(BlogStatus status);
        Page<Blog> findAllByStatus(BlogStatus status, Pageable pageable);
        boolean existsBySlug(String slug);
}

