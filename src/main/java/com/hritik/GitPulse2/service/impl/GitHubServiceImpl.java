package com.hritik.GitPulse2.service.impl;

import com.hritik.GitPulse2.dto.GitHubEvent;
import com.hritik.GitPulse2.service.GitHubService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.util.List;


@Service
public class GitHubServiceImpl implements GitHubService {
    private static final Logger logger = LoggerFactory.getLogger(GitHubServiceImpl.class);
    private static final String GITHUB_API_URL = "https://api.github.com/users/{username}/received_events";

    private final RestTemplate restTemplate;

    @Autowired
    public GitHubServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<GitHubEvent> fetchUserEvents(String username) {
        try {
            logger.info("Fetching events for GitHub user: {}", username);

            ResponseEntity<List<GitHubEvent>> response = restTemplate.exchange(
                    GITHUB_API_URL,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<GitHubEvent>>() {
                    },
                    username
            );

            List<GitHubEvent> events = response.getBody();
            logger.info("Fetched {} events for user: {}",
                    events != null ? events.size() : 0, username);

            return events != null ? events : new ArrayList<>();

        } catch (Exception e) {
            logger.error("Error fetching events for user: {}", username, e);
            return new ArrayList<>();
        }

    }
}
