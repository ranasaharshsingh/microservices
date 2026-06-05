package com.microservices.ratingservice.service;

import java.util.List;

import com.microservices.ratingservice.entities.Rating;

public interface RatingService {

    public Rating saveRating(Rating rating);
    public List<Rating> getRatingByUserId(String userId);
    public List<Rating> getRatingByHotelId(String hotelId);
    public List<Rating> getAllRatings();    

    
}
