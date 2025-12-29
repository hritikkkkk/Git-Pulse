package com.hritik.GitPulse2.service;

import com.hritik.GitPulse2.dto.GitHubEvent;
import org.springframework.stereotype.Component;

import java.util.List;


public interface GitHubService {

    /**
     * Fetches recent events for a GitHub user.
     *
     * @param username GitHub username
     * @return List of GitHub events
     */
    List<GitHubEvent> fetchUserEvents(String username);
}
