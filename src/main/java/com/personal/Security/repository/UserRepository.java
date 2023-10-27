package com.personal.Security.repository;

import com.personal.Security.user.ApplicationUser;
import com.personal.Security.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Role,Integer> {

    @Query("SELECT u FROM ApplicationUser u WHERE u.email = :email")
    Optional<ApplicationUser> findUserByEmail(String email);
}
