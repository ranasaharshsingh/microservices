package com.microservices.ratingservice.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.ratingservice.entities.Rating;
import com.microservices.ratingservice.repositories.RatingRepository;
import com.microservices.ratingservice.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {
        rating.setRatingId( UUID.randomUUID().toString());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatingByUserId(String user_id) {
        return ratingRepository.findByUserId(user_id);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotel_id) {
        return ratingRepository.findByHotelId(hotel_id);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();   
    }
    
}
