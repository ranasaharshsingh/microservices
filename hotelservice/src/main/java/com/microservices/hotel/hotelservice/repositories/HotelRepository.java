package com.microservices.hotel.hotelservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.hotel.hotelservice.entites.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,String>{
    
}
