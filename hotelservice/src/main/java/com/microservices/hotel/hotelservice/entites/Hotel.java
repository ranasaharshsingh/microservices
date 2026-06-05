package com.microservices.hotel.hotelservice.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="hotel_service")
public class Hotel {
    
    @Id
    @Column(name="hotel_id")
    private String hotelId;

    private String name;

    private String location;

    private String about;
}
