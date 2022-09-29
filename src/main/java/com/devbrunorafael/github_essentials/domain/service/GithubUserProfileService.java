package com.devbrunorafael.github_essentials.domain.service;

import com.devbrunorafael.github_essentials.domain.model.GithubRepositoriesModel;
import com.devbrunorafael.github_essentials.domain.model.GithubUserProfileModel;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class GithubUserProfileService {

    private WebClient webClient;

    public GithubUserProfileModel findUserProfileByUsername(String username){

        Mono<GithubUserProfileModel> userProfileModelMono = this.webClient
                .method(HttpMethod.GET)
                .uri("/{username}", username)
                .retrieve()
                .bodyToMono(GithubUserProfileModel.class);

        userProfileModelMono.subscribe(userProfileModel -> {
            System.out.println("Mono finished");
        });

        return userProfileModelMono.block();
    }

    public List<GithubRepositoriesModel> findAllAvailableRepositories(String username){

        Flux<GithubRepositoriesModel> repositoriesModelFlux = this.webClient
                .method(HttpMethod.GET)
                .uri("/{username}/repos", username)
                .retrieve()
                .bodyToFlux(GithubRepositoriesModel.class);

        repositoriesModelFlux.subscribe(userProfileModel -> {
            System.out.println("Flux finished");
        });
        List<GithubRepositoriesModel> repositories = repositoriesModelFlux
                .collectList().block();

        assert repositories != null;
        return repositories.stream()
                .skip(1)
                .collect(Collectors.toList());
    }

}
