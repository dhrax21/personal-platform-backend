package com.dhrax.platform.service;

import com.dhrax.platform.dto.BlogAdminResponse;
import com.dhrax.platform.dto.BlogRequest;

import java.util.List;

public interface BlogAdminService {

    BlogAdminResponse create(BlogRequest request);

    BlogAdminResponse update(Long id, BlogRequest request);

    List<BlogAdminResponse> findAll();

    void publish(Long id);

    void delete(Long id);
}
