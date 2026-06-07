package com.microservices.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.entities.User;
import com.microservices.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    
    
    
    @PostMapping
    
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId)
    {
       User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex)
    {
        
        User user = User.builder().email("dummy@gmail.com").name("Dummy").about("Since service is down hence a dummy user is provided to inform.").userId("404").build();
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @GetMapping
    @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback2")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }
    public ResponseEntity<List<User>> ratingHotelFallback2(Exception ex)
    {
        
        User user = User.builder().email("dummy@gmail.com").name("Dummy").about("Since service is down hence a dummy user is provided to inform.").userId("404").build();
        List<User> list = new ArrayList<>();
        list.add(user);
        return ResponseEntity.ok(list);
    }
}
