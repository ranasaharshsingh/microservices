package com.microservices.entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="user_service")
public class User {
    
    @Id
    @Column(name="user_id")
    private String userId;

    private String name;
    private String email;

    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
