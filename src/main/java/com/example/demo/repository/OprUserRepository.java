package com.example.demo.repository;

import com.example.demo.auth.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OprUserRepository extends JpaRepository<ApplicationUser,String> {
    ApplicationUser findByUserName(String userName);
}
