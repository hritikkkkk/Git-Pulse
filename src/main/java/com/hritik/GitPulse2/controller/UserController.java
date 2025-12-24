package com.hritik.GitPulse2.controller;

import com.hritik.GitPulse2.dto.UserRegistrationDto;
import com.hritik.GitPulse2.entity.User;
import com.hritik.GitPulse2.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserRegistrationDto registrationDto) {
        User user = userService.userRegister(registrationDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        user
                );
    }
}
