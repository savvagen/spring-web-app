package com.example.Services;

import com.example.Entity.User;

import java.util.List;

public interface UserService {


    void save(User user);

    User findOneByUsername(String username);

    User findOneByEmail(String email);

    User findOne(Long id);

    List<User> findAll();

    List<User> findAllByRole(String role);




}
