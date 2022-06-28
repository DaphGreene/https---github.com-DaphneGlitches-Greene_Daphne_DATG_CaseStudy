package com.datg.Greene_Daphne_DATG_CaseStudy.dto;


//import javax.validation.constraints.AssertTrue;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.*;

// import com.datg.Greene_Daphne_DATG_CaseStudy.repository.FieldMatch;

//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
// @FieldMatch.List({
//         @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
//         @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
// })
public class UserRegistrationDto {

    @NotEmpty(message = "Username is required.")
    @Length(min = 2)
    @Length(max = 20)
    private String username;

    @NotEmpty(message = "Password is required.")
//    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$", message = "Must include one lowercase, one uppercase, one number, and one special character.")
    @Length(min = 8, message = "Must be minimum of 8 characters")
    private String password;

    // @NotNull
    // private String confirmPassword;

    @Email(message = "Enter valid email address.")
    @NotEmpty(message = "Email address is required.")
    private String email;

    // @Email
    // @NotNull
    // private String confirmEmail;

    // @AssertTrue
    // private Boolean terms;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // public String getConfirmEmail() {
    //     return confirmEmail;
    // }

    // public void setConfirmEmail(String confirmEmail) {
    //     this.confirmEmail = confirmEmail;
    // }

    // public Boolean getTerms() {
    //     return terms;
    // }

    // public void setTerms(Boolean terms) {
    //     this.terms = terms;
    // }
}

