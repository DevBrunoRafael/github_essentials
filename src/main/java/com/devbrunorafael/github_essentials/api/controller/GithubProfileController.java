package com.devbrunorafael.github_essentials.api.controller;

import com.devbrunorafael.github_essentials.domain.model.GithubUserProfileModel;
import com.devbrunorafael.github_essentials.domain.service.GithubUserProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Api(value = "Api do github")
public class GithubProfileController {

    private GithubUserProfileService githubUserProfileService;

    @GetMapping("/{username}")
    @ApiOperation(value = "Retorna informações do perfil do usuário informado")
    public ResponseEntity<GithubUserProfileModel> findUserProfile(@PathVariable String username){
         GithubUserProfileModel userProfile = this.githubUserProfileService.searchUserProfile(username);
         return ResponseEntity.ok(userProfile);
    }
}
