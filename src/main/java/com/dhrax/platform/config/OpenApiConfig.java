package com.dhrax.platform.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI personalPlatformOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Personal Platform API")
                        .description("Backend APIs for blogs, admin management, and public content")
                        .version("v1.0"));
    }
}
