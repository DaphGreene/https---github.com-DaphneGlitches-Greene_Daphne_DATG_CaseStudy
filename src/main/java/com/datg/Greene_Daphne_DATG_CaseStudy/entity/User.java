package com.datg.Greene_Daphne_DATG_CaseStudy.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import lombok.*;

import java.sql.Date;
import java.util.Collection;
@Entity
@Data
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Email(message = "Enter valid email address.")
    @Column(unique = true)
    @NotEmpty(message = "Email address is required.")
    private String email;

     @NotEmpty(message = "Username is required.")
     @Column(unique = true)
     @Length(min = 2)
     @Length(max = 20)
    // @Pattern(regexp="[^\\s]+", message = "User name can not include spaces")
    private String username;

    @NotEmpty(message = "Password is required.")
//    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$", message = "Must include one lowercase, one uppercase, one number, and one special character.")
    @Length(min = 8, message = "Must be minimum of 8 characters")
    private String password;

    @Size(max = 200, message = "Your description may be up to 200 characters.")
    private String description = new String();

    // private Date targetDate;

    // private boolean active = true;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User() {
    }

    public User(String email, String username, String password, String description, Collection<Role> roles
    ) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.description = description;
        // this.targetDate = targetDate;
        this.roles = roles;
    }

    public User(String email, String username, String password, String description
    ) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.description = description;
        // this.targetDate = targetDate;
    }

    // Id
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    // Email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // Username
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    // Password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // Description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // // TargetDate
    // public Date getTargetDate() {
    //     return targetDate;
    // }
    // public void setTargetDate(Date targetDate) {
    //     this.targetDate = targetDate;
    // }

    // Roles
    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username+ '\'' +
                ", email='" + email + '\'' +
                ", password='" + "*********" + '\'' +
                ", roles=" + roles +
                '}';
    }

    
}