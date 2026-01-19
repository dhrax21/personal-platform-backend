package com.dhrax.platform.controller.admin;

import com.dhrax.platform.dto.BlogAdminResponse;
import com.dhrax.platform.dto.BlogRequest;
import com.dhrax.platform.service.BlogAdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/blogs")
@RequiredArgsConstructor
public class BlogAdminController {

    private final BlogAdminService blogAdminService;

    @PostMapping
    public BlogAdminResponse create(@Valid @RequestBody BlogRequest request) {
        return blogAdminService.create(request);
    }

    @PutMapping("/{id}")
    public BlogAdminResponse update(
            @PathVariable Long id,
            @Valid @RequestBody BlogRequest request
    ) {
        return blogAdminService.update(id, request);
    }

    @GetMapping
    public List<BlogAdminResponse> list() {
        return blogAdminService.findAll();
    }

    @PatchMapping("/{id}/publish")
    public void publish(@PathVariable Long id) {
        blogAdminService.publish(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        blogAdminService.delete(id);
    }
}
