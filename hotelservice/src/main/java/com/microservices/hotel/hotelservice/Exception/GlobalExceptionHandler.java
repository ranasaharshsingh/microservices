package com.microservices.hotel.hotelservice.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> resourceNotFoundExceptionhandler(ResourceNotFoundException ex)
    {
        HashMap<String,Object> map = new HashMap<>();
        map.put("message",ex.getMessage());
        map.put("suuccess",false);
        map.put("status",HttpStatus.NOT_FOUND );
        return ResponseEntity.ok(map);
    }
}
