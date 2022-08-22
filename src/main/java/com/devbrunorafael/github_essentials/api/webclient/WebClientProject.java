package com.devbrunorafael.github_essentials.api.webclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientProject {

    @Value("${api.url}")
    private String apiUrl;

    @Bean
    public WebClient webClient(WebClient.Builder webClientBuilder){
        return webClientBuilder
                .baseUrl(this.apiUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

}
