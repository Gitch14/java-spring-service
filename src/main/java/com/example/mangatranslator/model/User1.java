package com.example.mangatranslator.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Table(name = "account")
@Data
public class User1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String first_name;
    private String last_name;

}