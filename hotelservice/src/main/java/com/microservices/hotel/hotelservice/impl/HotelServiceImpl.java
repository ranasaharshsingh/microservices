package com.microservices.hotel.hotelservice.impl;

import com.microservices.hotel.hotelservice.repositories.HotelRepository;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.hotel.hotelservice.Exception.ResourceNotFoundException;
import com.microservices.hotel.hotelservice.Service.HotelService;
import com.microservices.hotel.hotelservice.entites.Hotel;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepository hotelRepository;

    HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        hotel.setHotelId(UUID.randomUUID().toString());
        return hotelRepository.save(hotel);

    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Cannot Find hotel with "+hotelId));
    }; 

    @Override
    public List<Hotel> getAllHotels() {

        return hotelRepository.findAll();
    }

   
    
}
