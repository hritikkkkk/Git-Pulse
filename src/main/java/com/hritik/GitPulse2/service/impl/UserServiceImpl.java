package com.hritik.GitPulse2.service.impl;

import com.hritik.GitPulse2.dto.UserRegistrationDto;
import com.hritik.GitPulse2.entity.User;
import com.hritik.GitPulse2.repository.UserRepository;
import com.hritik.GitPulse2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public User userRegister(UserRegistrationDto userRegistrationDto) {

        User user = User.builder().
                email(userRegistrationDto.getEmail())
                .githubUsername(userRegistrationDto.getGithubUsername())
                .build();
        return userRepository.save(user);
    }

}
