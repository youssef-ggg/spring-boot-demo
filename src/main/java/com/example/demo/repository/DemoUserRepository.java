package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DemoUser;

@Repository
public interface DemoUserRepository extends JpaRepository<DemoUser, Long>{

    List<DemoUser> findDemoUserByEmail(String email);
    
} 
