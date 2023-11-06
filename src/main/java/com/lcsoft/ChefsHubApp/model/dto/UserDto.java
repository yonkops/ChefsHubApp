package com.lcsoft.ChefsHubApp.model.dto;

import com.lcsoft.ChefsHubApp.model.entity.Recipe;
import com.lcsoft.ChefsHubApp.model.entity.Role;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<Role> roles;
    private List<Recipe> recipes;
    private LocalDate creationDate;
    private LocalDate lastLoginDate;

    public UserDto() {

    }

    public UserDto(String firstName, String lastName, String email, String password, Set<Role> roles, List<Recipe> recipes, LocalDate creationDate, LocalDate lastLoginDate) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.recipes = recipes;
        this.creationDate = creationDate;
        this.lastLoginDate = lastLoginDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDate lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
