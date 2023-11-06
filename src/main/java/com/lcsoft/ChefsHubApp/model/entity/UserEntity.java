package com.lcsoft.ChefsHubApp.model.entity;

import com.lcsoft.ChefsHubApp.model.entity.BaseEntity;
import com.lcsoft.ChefsHubApp.model.entity.Recipe;
import com.lcsoft.ChefsHubApp.model.entity.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column(nullable = false)
    @Size(min = 2, max = 30)
    private String firstName;
    @Column(nullable = false)
    @Size(min = 2, max = 30)
    private String lastName;
    @Column(nullable = false, unique = true)
    @Email
    private String email;
    @Column(nullable = false)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
    @OneToMany(mappedBy = "createdBy")
    private List<Recipe> recipes;
    private LocalDate creationDate;
    private LocalDate lastLoginDate;

    public UserEntity() {
    }

    public UserEntity(String firstName, String lastName, String email, String password, LocalDate creationDate) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.creationDate = creationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public UserEntity setRoles(Set<Role> role) {
        this.roles = role;
        return this;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public UserEntity setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
        return this;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public UserEntity setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public LocalDate getLastLoginDate() {
        return lastLoginDate;
    }

    public UserEntity setLastLoginDate(LocalDate lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
        return this;
    }
}
