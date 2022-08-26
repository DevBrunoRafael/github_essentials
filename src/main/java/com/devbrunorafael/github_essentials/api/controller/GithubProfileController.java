package com.devbrunorafael.github_essentials.api.controller;

import com.devbrunorafael.github_essentials.domain.model.GithubRepositoriesModel;
import com.devbrunorafael.github_essentials.domain.model.GithubUserProfileModel;
import com.devbrunorafael.github_essentials.domain.service.GithubUserProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Api(value = "Github API")
public class GithubProfileController {

    private GithubUserProfileService githubUserProfileService;

    @GetMapping("/{username}")
    @ApiOperation(value = "Fetches information from the informed user's profile")
    public ResponseEntity<GithubUserProfileModel> findUserProfile(@PathVariable String username){
         GithubUserProfileModel userProfile = this.githubUserProfileService.findUserProfileByUsername(username);
         return ResponseEntity.ok(userProfile);
    }

    @GetMapping("/{username}/repos")
    @ApiOperation(value = "Search available repositories of the informed user profile")
    public List<GithubRepositoriesModel> findAvailableRepositories(@PathVariable String username){
        return githubUserProfileService.findAllAvailableRepositories(username);
    }
}
