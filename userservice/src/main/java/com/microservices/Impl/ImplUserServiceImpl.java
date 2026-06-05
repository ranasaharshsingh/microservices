package com.microservices.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.Exception.ResourceNotFoundException;
import com.microservices.entities.Hotel;
import com.microservices.entities.Rating;
import com.microservices.entities.User;
import com.microservices.externalService.HotelService;
import com.microservices.externalService.RatingService;
import com.microservices.repositories.UserRepository;
import com.microservices.services.UserService;
import com.netflix.discovery.converters.Auto;

@Service
public class ImplUserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    RatingService ratingService;

    @Autowired
    HotelService hotelService;

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
        }

    @Override
    public List<User> getAllUser() {
        List<User> users= userRepository.findAll();
        users.forEach(user->{
            List<Rating> ratings=ratingService.getRating(user.getUserId());
            user.setRatings(ratings);
            ratings.forEach(rating->{
                Hotel hotel= hotelService.getHotel(rating.getHotelId());
                rating.setHotels(hotel);
            });
        });
        return users;    
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id not found on server"+userId));
       List<Rating> ratings = ratingService.getRating(user.getUserId());
       ratings.forEach(rating -> {

        Hotel hotel = hotelService.getHotel(rating.getHotelId());

        rating.setHotels(hotel);
       });
       
       user.setRatings(ratings);
       
        return user;
    }
    
}
