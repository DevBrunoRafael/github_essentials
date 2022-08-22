package com.devbrunorafael.github_essentials.api.controller;

import com.devbrunorafael.github_essentials.domain.model.GithubUserProfileModel;
import com.devbrunorafael.github_essentials.domain.service.GithubUserProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class GithubProfileController {

    private GithubUserProfileService githubUserProfileService;

    @GetMapping("/{username}")
    public ResponseEntity<GithubUserProfileModel> findUser(@PathVariable String username){
         GithubUserProfileModel userProfile = this.githubUserProfileService.searchUserProfile(username);
         return ResponseEntity.ok(userProfile);
    }
}
