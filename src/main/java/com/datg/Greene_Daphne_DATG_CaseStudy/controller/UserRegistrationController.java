package com.datg.Greene_Daphne_DATG_CaseStudy.controller;

import com.datg.Greene_Daphne_DATG_CaseStudy.dto.UserRegistrationDto;
import com.datg.Greene_Daphne_DATG_CaseStudy.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result){

        if (userService.findByEmail(userDto.getEmail()) != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (userService.findByUsername(userDto.getUsername()) != null){
            result.rejectValue("username", null, "There is already an account registered with that username");
        }
        if (result.hasErrors()){
            return "registration";
        }
        userService.save(userDto);
        return "redirect:/login?success";
    }
}