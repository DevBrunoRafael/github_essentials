package com.devbrunorafael.github_essentials.domain.service;

import com.devbrunorafael.github_essentials.domain.model.GithubUserProfileModel;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class GithubUserProfileService {

    private WebClient webClient;

    public GithubUserProfileModel searchUserProfile(String username){

        Mono<GithubUserProfileModel> userProfileModelMono = this.webClient
                .method(HttpMethod.GET)
                .uri("/{username}", username)
                .retrieve()
                .bodyToMono(GithubUserProfileModel.class);

        userProfileModelMono.subscribe(userProfileModel -> {
            System.out.println("finished");
        });

        return userProfileModelMono.block();
    }

}
