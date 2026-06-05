package com.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.entities.User;

public interface UserRepository extends JpaRepository<User,String>{
    
}
