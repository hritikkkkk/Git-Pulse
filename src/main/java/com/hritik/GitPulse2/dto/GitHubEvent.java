package com.hritik.GitPulse2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO representing a GitHub event from the API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class GitHubEvent {

    private String id;
    private String type;

    @JsonProperty("created_at")
    private String createdAt;

    private Actor actor;
    private Repo repo;
    private Payload payload;


    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Setter
    public static class Actor {
        private String login;

        @JsonProperty("display_login")
        private String displayLogin;
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Setter
    public static class Repo {
        private String name;
        private String url;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Setter
    public static class Payload {
        private String action;
    }
}