package com.lumina.resumeanalyzer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI resumeAnalyzerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AI Resume Analyzer API")
                        .description("API for analyzing resumes and matching them with job descriptions")
                        .version("v1"));
    }
}
