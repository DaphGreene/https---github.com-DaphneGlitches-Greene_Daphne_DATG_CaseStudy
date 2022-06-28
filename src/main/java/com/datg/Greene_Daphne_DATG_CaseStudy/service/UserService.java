package com.datg.Greene_Daphne_DATG_CaseStudy.service;


import com.datg.Greene_Daphne_DATG_CaseStudy.dto.UserRegistrationDto;
import com.datg.Greene_Daphne_DATG_CaseStudy.entity.User;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);
    User findByUsername(String username);
    User save(UserRegistrationDto registration);
}
