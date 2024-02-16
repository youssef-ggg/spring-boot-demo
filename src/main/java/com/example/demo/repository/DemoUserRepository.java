package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DemoUser;

@Repository
public interface DemoUserRepository extends JpaRepository<DemoUser, Integer>{

    Optional<DemoUser> findDemoUserByEmail(String email);
    
} 
