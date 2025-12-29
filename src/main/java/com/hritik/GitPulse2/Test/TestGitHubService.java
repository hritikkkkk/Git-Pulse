package com.hritik.GitPulse2.Test;

import com.hritik.GitPulse2.dto.GitHubEvent;
import com.hritik.GitPulse2.service.GitHubService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class TestGitHubService implements CommandLineRunner {

    private final GitHubService gitHubService;

    @Override
    public void run(String... args) throws Exception {
        String username = "hritikkkkk";
        List<GitHubEvent> events = gitHubService.fetchUserEvents(username);

        System.out.println("Total events fetched: " + events.size());
        events.forEach(event -> {
            System.out.println("Event ID: " + event.getId() +
                    ", Type: " + event.getType() +
                    ", Actor: " + (event.getActor() != null ? event.getActor().getLogin() : "null")
            );
        });
    }
}
