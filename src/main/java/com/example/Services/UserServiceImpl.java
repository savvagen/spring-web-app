package com.example.Services;

import com.example.Entity.User;
import com.example.Repository.RolesRepository;
import com.example.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesRepository rolesRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
    }

    @Override
    public User findOneByUsername(String username) {
       return usersRepository.findOneByUsername(username);
    }

    @Override
    public User findOneByEmail(String email) {
       return usersRepository.findOneByEmail(email);
    }

    @Override
    public User findOne(Long id) {
        return usersRepository.findOne(id);
    }

    @Override
    public List<User> findAll() {
       return usersRepository.findAll();
    }

    @Override
    public List<User> findAllByRole(String role) {
        return rolesRepository.findOneByName(role).getUsers();
    }
}
