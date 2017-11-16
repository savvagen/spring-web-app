package com.example.Repository;


import com.example.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    User findOneByEmail(String email);

    User findOneByUsername(String username);

    List<User> findAllByRolesEquals(String role);


}
