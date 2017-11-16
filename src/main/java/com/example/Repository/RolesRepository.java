package com.example.Repository;

import com.example.Entity.Role;
import com.example.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long>{

    Role findOneByName(String role);


}
