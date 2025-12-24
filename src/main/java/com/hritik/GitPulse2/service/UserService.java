package com.hritik.GitPulse2.service;

import com.hritik.GitPulse2.dto.UserRegistrationDto;
import com.hritik.GitPulse2.entity.User;

public interface UserService {
    User userRegister(UserRegistrationDto userRegistrationDto);
}
