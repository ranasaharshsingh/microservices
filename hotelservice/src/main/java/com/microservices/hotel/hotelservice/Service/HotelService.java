package com.microservices.hotel.hotelservice.Service;

import java.util.List;

import com.microservices.hotel.hotelservice.entites.Hotel;

public interface HotelService {
    
    public Hotel saveHotel(Hotel hotel);

    public Hotel getHotelById(String hotelId);

    public List<Hotel> getAllHotels();

}
