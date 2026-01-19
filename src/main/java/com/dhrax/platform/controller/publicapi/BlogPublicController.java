package com.dhrax.platform.controller.publicapi;

import com.dhrax.platform.dto.BlogPublicResponse;
import com.dhrax.platform.service.BlogPublicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/blogs")
@RequiredArgsConstructor
public class BlogPublicController {

    private final BlogPublicService blogPublicService;
    @GetMapping
    public Page<BlogPublicResponse> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return blogPublicService.listPublished(page, size);
    }
    @GetMapping("/{slug}")
    public BlogPublicResponse getBySlug(@PathVariable String slug) {
        return blogPublicService.getBySlug(slug);
    }
}
