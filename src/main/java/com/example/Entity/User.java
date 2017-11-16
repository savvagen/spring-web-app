package com.example.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.PublicKey;
import java.util.List;
import java.util.Set;



@Entity
@Table(name = "users")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter Long id;


    @Column(name = "username")
    @JsonProperty("username")
    private @Getter @Setter String username;

    @Column(name = "email")
    @JsonProperty("email")
    private @Getter @Setter String email;

    @Column(name = "password")
    @JsonIgnore
    private @Getter @Setter String password;

    @Transient
    @JsonIgnore
    private @Getter @Setter String confirmPassword;

    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private @Getter @Setter List<Role> roles;


    public User(){}



}

