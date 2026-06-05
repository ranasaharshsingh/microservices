package com.microservices.ratingservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Rating {
    
    @Id
    @Column(name="rating_id")
    private String ratingId;
    @Column(name="user_id")
    private String userId;
    @Column(name="hotel_id")
    private String hotelId;

    private int ratings;

    private String feedback;

}
