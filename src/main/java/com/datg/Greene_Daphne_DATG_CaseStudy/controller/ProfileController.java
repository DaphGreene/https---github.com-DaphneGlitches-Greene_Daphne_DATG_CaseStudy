package com.datg.Greene_Daphne_DATG_CaseStudy.controller;

import java.security.Principal;
import java.util.Objects;

import com.datg.Greene_Daphne_DATG_CaseStudy.dto.UserProfileDto;
import com.datg.Greene_Daphne_DATG_CaseStudy.entity.User;
import com.datg.Greene_Daphne_DATG_CaseStudy.repository.UserRepository;
import com.datg.Greene_Daphne_DATG_CaseStudy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProfileController {
    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping(value="/profile")
    public String profile(Model model, Principal principal) {
        String email = principal.getName();
        User user = userService.findByEmail(email);

        model.addAttribute("user", user);

        return "profile";
    }

    @PostMapping(value="/profile")
    public String profile(@ModelAttribute("user") @Valid UserProfileDto userProfileDto, BindingResult result, Principal principal) {
        String email = principal.getName();
        User user = userService.findByEmail(email);

        logger.info("WHY, DEAR LORD");
        if (result.hasErrors()){
            logger.info("BECAUSE ERRORS");
            return "profile";
        }

        if (!Objects.equals(userProfileDto.getPassword(), "")) {
            user.setPassword(passwordEncoder.encode(userProfileDto.getPassword()));
        }
        user.setDescription(userProfileDto.getDescription());
        userRepository.save(user);
        return "redirect:/profile?success";
    }
}
