package com.personal.Security.repository;

import com.personal.Security.user.ApplicationUser;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;


public interface UserRepository extends JpaRepository<ApplicationUser,Integer> {

    @Query("SELECT u FROM ApplicationUser u WHERE u.email = :email")
    Optional<ApplicationUser> findUserByEmail(String email);
}
