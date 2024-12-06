package com.example.horizon_barber_service.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "barbers")
@Data
public class Barber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;
}
