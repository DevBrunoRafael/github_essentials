package com.devbrunorafael.github_essentials.domain.model;

import lombok.Data;

@Data
public class GithubUserProfileModel {

    private String login;
    private String avatar_url;
    private String name;
    private String company;
    private String blog;
    private String location;

}
