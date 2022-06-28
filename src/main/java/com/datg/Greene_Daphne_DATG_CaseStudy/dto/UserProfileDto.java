package com.datg.Greene_Daphne_DATG_CaseStudy.dto;


//import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
public class UserProfileDto {
    //  @NotEmpty(message = "Password is required.")
    //    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$", message = "Must include one lowercase, one uppercase, one number, and one special character.")
    //    @Length(min = 8, message = "Must be minimum of 8 characters")
    private String password;

    @Size(max = 200, message = "Your description may be up to 200 characters.")
    private String description;

    // @NotNull
    // private String confirmPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // public String getConfirmPassword() {
    //     return confirmPassword;
    // }

    // public void setConfirmPassword(String confirmPassword) {
    //     this.confirmPassword = confirmPassword;
    // }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

